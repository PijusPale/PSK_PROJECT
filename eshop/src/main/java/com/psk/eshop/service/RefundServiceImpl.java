package com.psk.eshop.service;

import com.psk.eshop.dto.RefundRequestDTO;
import com.psk.eshop.model.Refund;
import com.psk.eshop.repository.RefundRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class RefundServiceImpl implements RefundService{
    private final RefundRepository refundRepository;
    @Override
    public Refund saveRefund(RefundRequestDTO refundRequest) {
        var newRefund = Refund.builder()
                .orderId(refundRequest.getOrderId())
                .businessId(refundRequest.getBusinessId())
                .refundStatus(refundRequest.getRefundStatus())
                .createdDate(refundRequest.getCreatedDate())
                .customerId(refundRequest.getCustomerId())
                .description(refundRequest.getDescription())
                .build();
        return refundRepository.save(newRefund);
    }

    @Override
    public List<Refund> getRefunds() {
        return refundRepository.findAll();
    }

    @Override
    public Refund updateRefund(Long refundId, RefundRequestDTO refundRequest) {
        return refundRepository.findById(refundId)
                .map(refund -> {
                    refund.setRefundStatus(refundRequest.getRefundStatus());
                    refund.setDescription(refundRequest.getDescription());
                    refund.setBusinessId(refundRequest.getBusinessId());
                    refund.setCreatedDate(refundRequest.getCreatedDate());
                    refund.setCustomerId(refundRequest.getCustomerId());
                    refund.setOrderId(refundRequest.getOrderId());
                    return refundRepository.save(refund);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Refund with id %d not found", refundId))
                );
    }

    @Override
    public Refund getRefundById(Long refundId) {
        return refundRepository.findById(refundId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Refund with id %d not found", refundId))
        );
    }
}