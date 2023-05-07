package bg.fmi.course.dealership.service;

import bg.fmi.course.dealership.model.Invoice;
import bg.fmi.course.dealership.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getInvoices() {
        log.info("Get all invoices from database");
        return invoiceRepository.findAll();
    }

    public List<Invoice> getInvoicesWithPriceLessThen(BigDecimal totalPrice) {
        log.info("Get all invoices with total price less then {}", totalPrice);
        return invoiceRepository.findInvoicesByTotalPriceLessThan(totalPrice);
    }

    public Long createInvoice(Invoice invoice) {

        if (invoice == null) {
            throw new IllegalArgumentException("Invoice cannot be null");
        }

        log.info("Invoice created, source = {}", invoice);
        return invoiceRepository.save(invoice).getId();
    }

}
