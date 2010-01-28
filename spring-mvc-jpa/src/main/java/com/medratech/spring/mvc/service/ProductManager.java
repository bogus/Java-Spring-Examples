package com.medratech.spring.mvc.service;

import java.util.List;

import com.medratech.spring.mvc.domain.Product;

public interface ProductManager {
    public void increasePrice(int percentage);
    public List<Product> getProducts();
}
