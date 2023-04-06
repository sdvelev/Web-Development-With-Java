package bg.uni.fmi.lab03.cardealershiptaskone.repository;

import bg.uni.fmi.lab03.cardealershiptaskone.model.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
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
