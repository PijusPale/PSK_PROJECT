package com.psk.eshop.service;

import com.psk.eshop.dto.ProductRequestDTO;
import com.psk.eshop.model.Product;
import com.psk.eshop.repository.ProductRepository;
import com.psk.eshop.utils.FileUploadUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
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
                .picturePath(getPicturePath(productRequest.getPicture(), productRequest.getUserId()))
//                .picture(getPictureIfNotEmpty(productRequest.getPicture()))
                .build();
        return productRepository.save(newProduct);
    }

    private String getPicturePath(MultipartFile picture, Long userId) {
        String fileName = StringUtils.cleanPath(picture.getOriginalFilename());
        String uploadDir = "user-photos/" + userId;

        try {
            FileUploadUtil.saveFile(uploadDir, fileName, picture);
        }
        catch (IOException ex){
            return null;
        }

        return fileName;
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
                    product.setPicturePath(getPicturePath(productRequest.getPicture(), productRequest.getUserId()));
//                    product.setPicture(getPictureIfNotEmpty(productRequest.getPicture()));
                    return productRepository.save(product);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product with id %d not found", productId))
                );
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
