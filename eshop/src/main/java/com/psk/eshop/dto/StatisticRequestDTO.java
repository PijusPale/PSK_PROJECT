package com.psk.eshop.dto;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class StatisticRequestDTO {
    private Long orderId;
    private Timestamp createdDate;
    private String description;
}
