package com.fed.commerce.repository.impl;


import com.fed.commerce.model.User;
import com.fed.commerce.repository.OrderRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

/*    @Override
    public User checkLogin(User input) {
        TypedQuery<User> query=entityManager.createQuery("from User where id= :uid and password= :password ", User.class);
        query.setParameter("uid", input.getId());
        query.setParameter("password", input.getPassword());
        return query.getSingleResult();
    }*/
}
