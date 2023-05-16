package com.psk.eshop.service;

import com.psk.eshop.dto.ProductRequestDTO;
import com.psk.eshop.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequestDTO product, MultipartFile file);
    List<Product> getProducts();
    Product getProductById(Long productId);
    Product updateProduct(Long productId, ProductRequestDTO productRequest, MultipartFile file);
}
