package com.psk.eshop.service;

import com.psk.eshop.dto.ProductRequestDTO;
import com.psk.eshop.model.Product;
import com.psk.eshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
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
                .picture(getPictureIfNotEmpty(productRequest.getPicture()))
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
                    product.setPicture(getPictureIfNotEmpty(productRequest.getPicture()));
                    return productRepository.save(product);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product with id %d not found", productId))
                );
    }
    @Override
    public void deleteProductById(Long productId) {
        Product product = getProductById(productId);

        if (hasActiveOrdersWithProduct(product)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, String.format("Cannot delete product. There are active orders with this product (productId = %d).", productId));
        }

        productRepository.deleteById(productId);
    }

    private boolean hasActiveOrdersWithProduct(Product product) {
        return !product.getOrders().isEmpty();
    }

    private byte[] getPictureIfNotEmpty(MultipartFile picture){
        if(picture.isEmpty()){
            return null;
        }
        else {
            try {
                return picture.getBytes();
            } catch (IOException e) {
                // Handle error reading picture data
                return null;
            }
        }
    }
}
