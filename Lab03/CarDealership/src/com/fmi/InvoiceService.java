package com.fmi;

import java.util.List;

public class InvoiceService {

    private InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void addInvoice(Invoice invoiceToAdd) {
        this.invoiceRepository.addInvoice(invoiceToAdd);
    }

    public List<Invoice> getInvoiceHistory() {
        return this.invoiceRepository.getInvoiceHistory();
    }

    public double calculateTotalPrice() {

        double result = 0;

        for (Invoice invoice : this.getInvoiceHistory()) {

            result += invoice.getSalesPrice() * (1 + invoice.getTaxRate() / 100.0);
        }

        return result;
    }

}
