package com.fed.commerce.repository.impl;

import com.fed.commerce.model.Cart;
import com.fed.commerce.model.Product;
import com.fed.commerce.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getAllProducts() {
        TypedQuery<Product> query = entityManager.createQuery(" FROM Product ", Product.class);
        return query.getResultList();
    }

    @Override
    public Product getProductbyId(int sku) {
        TypedQuery<Product> query = entityManager.createQuery("from  Product  WHERE sku =:  sku", Product.class);
        query.setParameter("sku", sku);
        return query.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    @Transactional
    public void saveProduct(Product prodData) {
        entityManager.persist(prodData);
    }

    @Override
    @Transactional
    public void updateProd(Product prodData) {
        entityManager.merge(prodData);
    }
}
