package com.psk.eshop.model;

import com.psk.eshop.enums.PaymentType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId; //TODO map with orders when created
    private Long customerId; //TODO map with customer when customer is created
//    private Set<Product> products;//TODO map with product when created. OneToMany
    private Timestamp createdDate;
    private PaymentType paymentType;
    private BigDecimal amount;
    private String notes;
}
