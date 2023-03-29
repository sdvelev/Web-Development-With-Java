package bg.uni.fmi.lab03.cardealershiptaskone.service;

import bg.uni.fmi.lab03.cardealershiptaskone.model.Invoice;
import bg.uni.fmi.lab03.cardealershiptaskone.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService() {
        this.invoiceRepository = new InvoiceRepository();
    }

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void addInvoice(Invoice invoiceToAdd) {
        this.invoiceRepository.addInvoice(invoiceToAdd);
    }

    public List<Invoice> getInvoiceHistory() {
        return this.invoiceRepository.getInvoiceHistory();
    }

    public void printInvoice(Invoice invoice) {

        System.out.println(invoice);
    }

    public double calculateTotalPrice() {

        return this.getInvoiceHistory().stream()
            .reduce(0.0, (result, current) -> result  + current.getTotalPrice(), Double::sum);
    }

}
