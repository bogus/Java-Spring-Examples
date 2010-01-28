package com.medratech.spring.mvc.repository;

import java.util.List;

import com.medratech.spring.mvc.domain.Product;

public interface ProductDao {
    public List<Product> getProductList();
    public void saveProduct(Product prod);
}
