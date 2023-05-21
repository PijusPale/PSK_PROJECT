package com.psk.eshop.dto;

import com.psk.eshop.enums.OrderStatus;
import lombok.Getter;

import java.util.List;

@Getter
public class OrderRequestDTO {
    private List<Long> productIds;
    private String userEmail;
    private OrderStatus orderStatus;
    private String shippingAddress;
}
