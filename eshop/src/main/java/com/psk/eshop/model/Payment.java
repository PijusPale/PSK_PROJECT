package com.psk.eshop.model;

import com.psk.eshop.enums.PaymentType;
import com.psk.eshop.enums.TransactionState;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId; //TODO map when order model is created
    private PaymentType paymentType;
    private BigDecimal amount;
    private Timestamp transactionDate;
    private TransactionState transactionState;
    private String billingAddress;
}
