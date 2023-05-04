package bg.fmi.course.wdwj.dealership.service;

import bg.fmi.course.wdwj.dealership.model.Invoice;
import bg.fmi.course.wdwj.dealership.repository.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Slf4j
@Service
public class InvoiceService {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getInvoices() {
        log.info("Get all invoices from DB");
        return invoiceRepository.findAll();
    }

    public List<Invoice> getInvoicesLessThen(BigDecimal totalPrice) {
        log.info("Get all invoices with total price less then {}", totalPrice);
        return invoiceRepository.findInvoicesByTotalPriceLessThan(totalPrice);
    }


    public Long createInvoice(Invoice invoice) {
        log.info("Create invoice, source = {}", invoice);
        return invoiceRepository.save(invoice).getId();
    }


    /*
    public void addInvoice(Invoice invoice) {
        invoiceRepository.addInvoice(invoice);
    }

    public List<Invoice> getInvoiceHistory() {
        return invoiceRepository.getInvoiceHistory();
    }

    public BigDecimal calculateTotalPrice(Invoice invoice) {
        BigDecimal totalPrice = invoice.getSalesPrice();

        // Add tax to the total price
        BigDecimal tax = totalPrice.multiply(invoice.getTaxRate());
        totalPrice = totalPrice.add(tax);

        return totalPrice.setScale(2, RoundingMode.HALF_UP);
    }*/
}

