package com.psk.eshop.controller;

import com.psk.eshop.model.Product;
import com.psk.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/e-shop")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public String add(@RequestBody Product product){
        productService.saveProduct(product);
        return "new product is added!";
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
}
