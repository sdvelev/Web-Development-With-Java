package bg.fmi.course.wdwj.dealership.controller;

import bg.fmi.course.wdwj.dealership.dto.InvoiceDto;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private InvoiceService invoiceService;

    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping
    public void createInvoice() {
        invoiceService.createInvoice(Invoice.builder()
                .invoiceDate(LocalDate.now())
                .basePrice(new BigDecimal("123"))
            .build());
    }
/*
    @GetMapping
    public List<InvoiceDto> getInvoices() {
        List<Invoice> invoices = this.invoiceService.getInvoice();

        return invoices.stream()
            .map(el -> InvoiceDto.builder()
                .salesPrice(el.getTotalPrice())
                .build())
            .collect(Collectors.toList());
    }*/

}