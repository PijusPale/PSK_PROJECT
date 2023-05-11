package com.psk.eshop.service;

import com.psk.eshop.dto.ProductRequestDTO;
import com.psk.eshop.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequestDTO product);
    List<Product> getProducts();
    Product getProductById(Long productId);
    Product updateProduct(Long productId, ProductRequestDTO productRequest);
}
