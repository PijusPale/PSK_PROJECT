package com.psk.eshop.controller;

import com.psk.eshop.dto.PaymentRequestDTO;
import com.psk.eshop.model.Payment;
import com.psk.eshop.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/e-shop")
@CrossOrigin("*")
@AllArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    @PostMapping(value = "/payment")
    public Payment add(@RequestBody PaymentRequestDTO paymentRequest){
        return paymentService.createPayment(paymentRequest);
    }

    @GetMapping("/payments")
    public List<Payment> getPayments(){
        return paymentService.getPayments();
    }

    @GetMapping("/payment/{paymentId}")
    public Payment getPaymentById(@PathVariable Long paymentId){
        return paymentService.getPaymentById(paymentId);
    }

    @PutMapping("/payment/{paymentId}")
    public Payment update(@PathVariable Long paymentId, @RequestBody PaymentRequestDTO paymentRequest){
        return paymentService.updatePayment(paymentId, paymentRequest);
    }
    @DeleteMapping("/payment/{paymentId}")
    public void deletePaymentById(@PathVariable Long paymentId)
    {
        paymentService.deletePaymentById(paymentId);
    }
}
