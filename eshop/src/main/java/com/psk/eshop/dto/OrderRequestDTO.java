package com.psk.eshop.dto;

import com.psk.eshop.enums.OrderStatus;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class OrderRequestDTO {
    private Long userId;
    private OrderStatus orderStatus;
    private BigDecimal price;
    private String shippingAddress;
}
