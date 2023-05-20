package com.psk.eshop.controller;

import com.psk.eshop.dto.InvoiceRequestDTO;
import com.psk.eshop.model.Invoice;
import com.psk.eshop.service.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/e-shop")
@CrossOrigin("*")
@AllArgsConstructor
public class InvoiceController {
    private final InvoiceService invoiceService;
    @PostMapping(value = "/invoice")
    public Invoice add(@RequestBody InvoiceRequestDTO invoiceRequest){
        return invoiceService.createInvoice(invoiceRequest);
    }

    @GetMapping("/invoices")
    public List<Invoice> getInvoices(){
        return invoiceService.getInvoices();
    }

    @GetMapping("/invoice/{invoiceId}")
    public Invoice getInvoiceById(@PathVariable Long invoiceId){
        return invoiceService.getInvoiceById(invoiceId);
    }

    @PutMapping("/invoice/{invoiceId}")
    public Invoice update(@PathVariable Long invoiceId, @RequestBody InvoiceRequestDTO invoiceRequest){
        return invoiceService.updateInvoice(invoiceId, invoiceRequest);
    }
    @DeleteMapping("/invoice/{invoiceId}")
    public void deleteInvoiceById(@PathVariable Long invoiceId)
    {
        invoiceService.deleteInvoiceById(invoiceId);
    }
}
