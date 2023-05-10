package com.psk.eshop.dto;

import com.psk.eshop.enums.PaymentType;
import com.psk.eshop.enums.TransactionState;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
public class PaymentRequestDTO {
    private Long orderId;
    private PaymentType paymentType;
    private BigDecimal amount;
    private Timestamp transactionDate;
    private TransactionState transactionState;
    private String billingAddress;
}
