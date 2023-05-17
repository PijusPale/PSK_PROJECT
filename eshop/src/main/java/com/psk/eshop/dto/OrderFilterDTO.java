package com.psk.eshop.dto;

import com.psk.eshop.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderFilterDTO {
    private Long userId;
    private OrderStatus orderStatus;
}
