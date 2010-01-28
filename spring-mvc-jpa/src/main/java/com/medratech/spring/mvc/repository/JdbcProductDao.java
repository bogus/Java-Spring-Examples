package com.medratech.spring.mvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.medratech.spring.mvc.domain.Product;

@Repository
public class JdbcProductDao implements ProductDao {
    
    @PersistenceContext        
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
    public List<Product> getProductList() {
        Query query = this.entityManager.createQuery("from Product");
        
        return query.getResultList();
    }

    @Transactional
    public void saveProduct(Product product) {
        entityManager.merge(product);        
    }

    public void setEntityManager(EntityManager entityManager) {
        entityManager = entityManager;
    }
}
