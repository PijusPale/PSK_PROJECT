package com.psk.eshop.dto;

import com.psk.eshop.enums.RefundStatus;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class RefundRequestDTO {
    private Long orderId;
    private Long customerId;
    private RefundStatus refundStatus;
    private Timestamp createdDate;
    private String description;
}
