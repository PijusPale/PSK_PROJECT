package com.psk.eshop.service;

import com.psk.eshop.dto.InvoiceRequestDTO;
import com.psk.eshop.model.Invoice;

import java.util.List;

public interface InvoiceService {
    Invoice getInvoiceById(Long invoiceId);
    Invoice createInvoice(InvoiceRequestDTO invoiceRequest);
    Invoice updateInvoice(Long invoiceId, InvoiceRequestDTO invoiceRequest);
    List<Invoice> getInvoices();
}
