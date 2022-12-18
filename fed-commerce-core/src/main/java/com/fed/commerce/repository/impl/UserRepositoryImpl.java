package com.fed.commerce.repository.impl;


import com.fed.commerce.model.User;
import com.fed.commerce.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User checkLogin(User input) {
        TypedQuery<User> query = entityManager.createQuery("from User where userId= :uid and password= :password ", User.class);
        query.setParameter("uid", input.getUserId());
        query.setParameter("password", input.getPassword());
        return query.getSingleResult();
    }

}
