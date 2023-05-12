package com.psk.eshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.psk.eshop.enums.PaymentType;
import jakarta.persistence.*;
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
    private Timestamp createdDate;
    private PaymentType paymentType;
    private BigDecimal amount;
    private String notes;
}
