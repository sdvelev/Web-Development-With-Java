package bg.fmi.course.wdwj.dealership.controller;

import bg.fmi.course.wdwj.dealership.model.Car;
import bg.fmi.course.wdwj.dealership.model.Invoice;
import bg.fmi.course.wdwj.dealership.service.InvoiceService;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public void addInvoice(@Valid @NotNull @RequestBody Invoice invoice) {
        invoiceService.addInvoice(invoice);
    }

    @GetMapping
    public List<Invoice> getInvoiceHistory() {
        return invoiceService.getInvoiceHistory();
    }

    @GetMapping("/totalPrice")
    public BigDecimal calculateTotalPrice(@RequestParam("customerName") String customerName,
                                          @RequestParam("purchaseDate") LocalDate purchaseDate,
                                          @RequestParam("carMake") String make,
                                          @RequestParam("carModel") String model,
                                          @RequestParam("year") int year,
                                          @RequestParam("price") BigDecimal price,
                                          @RequestParam("salesPrice") BigDecimal salesPrice,
                                          @RequestParam("taxRate") BigDecimal taxRate) {
        return invoiceService.calculateTotalPrice(new Invoice(customerName, purchaseDate,
            new Car(make, model, year, price), salesPrice, taxRate));
    }
}