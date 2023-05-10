package com.psk.eshop.model;

import com.psk.eshop.enums.RefundStatus;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderId; //TODO add mapping when order model is created
    private Long customerId; //TODO add mapping when customer model is created
    private Long businessId; //TODO add mapping when business model is created
    private RefundStatus refundStatus;
    private Timestamp createdDate;
    private String description;
}
