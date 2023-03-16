package com.fmi;

import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository {

    private final List<Invoice> invoiceRepository;

    public InvoiceRepository() {
        this.invoiceRepository = new ArrayList<>();
    }

    public void addInvoice(Invoice invoiceToAdd) {
        this.invoiceRepository.add(invoiceToAdd);
    }

    public List<Invoice> getInvoiceHistory() {
        return this.invoiceRepository;
    }
}
