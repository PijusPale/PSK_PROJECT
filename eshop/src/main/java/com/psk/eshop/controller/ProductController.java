package com.psk.eshop.controller;

import com.psk.eshop.dto.ProductRequestDTO;
import com.psk.eshop.model.Product;
import com.psk.eshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/e-shop")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/product")
    public Product add(@RequestParam MultipartFile file){
        ProductRequestDTO product = ProductRequestDTO.builder()
                .description("lala")
                .price(new BigDecimal(5))
                .name("flower")
                .build();
        return productService.createProduct(product, file);
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @GetMapping("/product/{productId}")
    public Product getProductById(@PathVariable Long productId){
        return productService.getProductById(productId);
    }

    @PutMapping("/product/{productId}")
    public Product update(@PathVariable Long productId, @RequestBody ProductRequestDTO productRequest, @RequestParam MultipartFile file){
        return productService.updateProduct(productId, productRequest, file);
    }

    @DeleteMapping("/product/{productId}")
    public void deleteProductById(@PathVariable Long productId)
    {
        productService.deleteProductById(productId);
    }
}
