package com.psk.eshop.service;

import com.psk.eshop.dto.PaymentRequestDTO;
import com.psk.eshop.model.Payment;
import java.util.List;

public interface PaymentService {
    Payment getPaymentById(Long paymentId);
    List<Payment> getPayments();
    Payment createPayment(PaymentRequestDTO paymentRequest);
    Payment updatePayment(Long paymentId, PaymentRequestDTO paymentRequest);
    void deletePaymentById(Long paymentId);
}
