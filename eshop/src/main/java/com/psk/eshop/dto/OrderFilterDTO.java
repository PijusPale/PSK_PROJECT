package com.psk.eshop.dto;

import com.psk.eshop.enums.OrderStatus;
import lombok.Getter;

@Getter
public class OrderFilterDTO {
    private String userEmail;
    private OrderStatus orderStatus;
}
