package com.psk.eshop.dto;

import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Getter
public class ProductRequestDTO {
    private Long userId;
    private Long discountId;
    private BigDecimal price;
    private String name;
    private String description;
    private MultipartFile picture;
}
