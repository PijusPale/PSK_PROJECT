package com.psk.eshop.dto;

import com.psk.eshop.enums.OrderStatus;
import lombok.Getter;

@Getter
public class OrderFilterDTO {
    private Long userId;
    private OrderStatus orderStatus;
}
