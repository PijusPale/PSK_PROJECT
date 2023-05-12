package com.psk.eshop.service;

import com.psk.eshop.dto.ProductRequestDTO;
import com.psk.eshop.model.Product;
import com.psk.eshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    @Override
    public Product createProduct(ProductRequestDTO productRequest) {
        var newProduct = Product.builder()
                .userId(productRequest.getUserId())
                .discountId(productRequest.getDiscountId())
                .price(productRequest.getPrice())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .build();
        return productRepository.save(newProduct);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product with id %d not found", productId))
        );
    }
    @Override
    public Product updateProduct(Long productId, ProductRequestDTO productRequest) {
        return productRepository.findById(productId)
                .map(product -> {
                    product.setUserId(productRequest.getUserId());
                    product.setDiscountId(productRequest.getDiscountId());
                    product.setPrice(productRequest.getPrice());
                    product.setName(productRequest.getName());
                    product.setDescription(productRequest.getDescription());
                    return productRepository.save(product);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product with id %d not found", productId))
                );
    }
}
