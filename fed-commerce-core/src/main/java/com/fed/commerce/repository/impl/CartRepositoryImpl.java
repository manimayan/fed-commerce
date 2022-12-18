package com.fed.commerce.repository.impl;

import com.fed.commerce.model.Cart;
import com.fed.commerce.repository.CartRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CartRepositoryImpl implements CartRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Cart getCartData(Cart cartData) {
        TypedQuery<Cart> query = entityManager.createQuery("from  Cart  WHERE user.userId =:  userId AND product.sku =: sku", Cart.class);
        query.setParameter("userId", cartData.getUser().getUserId());
        query.setParameter("sku", cartData.getProduct().getSku());
        return query.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    @Transactional
    public void updateCart(Cart cartData) {
        entityManager.merge(cartData);
    }

    @Override
    @Transactional
    public void saveCart(Cart cartData) {
        entityManager.persist(cartData);
    }


    @Override
    public List<Cart> getAllCartEntries() {
        TypedQuery<Cart> query = entityManager.createQuery("from Cart", Cart.class);
        return query.getResultList();
    }

    @Override
    public List<Cart> getUserCart(String userId) {
        TypedQuery<Cart> query = entityManager.createQuery("from  Cart  WHERE user.userId =:userId", Cart.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void deleteUserCart(String userId) {
        Query query = entityManager.createQuery("delete from Cart WHERE user.userId=:userId");
        query.setParameter("userId", userId);
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteProdCart(String userId, int prodId) {
        Query query = entityManager.createQuery("delete from Cart WHERE user.userId=:userId AND product.prodId =: productId");
        query.setParameter("userId", userId);
        query.setParameter("productId", prodId);
        query.executeUpdate();
    }
}
