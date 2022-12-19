package com.fed.commerce.repository.impl;


import com.fed.commerce.model.Orders;
import com.fed.commerce.repository.OrdersRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
public class OrdersRepositoryImpl implements OrdersRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Orders updateOrders(Orders orders) {
        entityManager.persist(orders);
        return entityManager.createQuery("SELECT orderRecord FROM Orders orderRecord ORDER BY orderRecord.ordersId desc",
                Orders.class).setMaxResults(1).getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public List<Orders> getUserOrders(String userId) {
        TypedQuery<Orders> query = entityManager.createQuery("from Orders WHERE user.userId =:userId", Orders.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    public List<Orders> getAllOrdersEntry() {
        TypedQuery<Orders> query = entityManager.createQuery("from Orders", Orders.class);
        return query.getResultList();
    }

    @Override
    public Orders getLastOrdersBatch() {
        return entityManager.createQuery("SELECT orderRecord FROM Orders orderRecord ORDER BY orderRecord.ordersId desc",
                Orders.class).setMaxResults(1).getResultList().stream().findFirst().orElse(null);
    }
}
