package com.psk.eshop.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

@Getter
@Builder
public class ProductRequestDTO {
    private Long userId;
    private Long discountId;
    private BigDecimal price;
    private String name;
    private String description;

    @JsonCreator
    public ProductRequestDTO(@JsonProperty("userId") Long userId, @JsonProperty("discountId") Long discountId,
                             @JsonProperty("price") BigDecimal price, @JsonProperty("name") String name,
                             @JsonProperty("description") String description) {
        this.userId = userId;
        this.discountId = discountId;
        this.price = price;
        this.name = name;
        this.description = description;
    }
}
