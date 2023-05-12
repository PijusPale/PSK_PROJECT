package com.psk.eshop.dto;

import com.psk.eshop.enums.PaymentType;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
public class InvoiceRequestDTO {
    private Long orderId;
    //    private Set<Product> products;
    private Timestamp createdDate;
    private PaymentType paymentType;
    private BigDecimal amount;
    private String notes;
}
