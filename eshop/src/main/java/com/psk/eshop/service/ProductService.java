package com.psk.eshop.service;

import com.psk.eshop.model.Product;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);
    public List<Product> getProducts();
}
