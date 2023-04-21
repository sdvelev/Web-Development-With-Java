package bg.fmi.course.wdwj.dealership.dto;

import bg.fmi.course.wdwj.dealership.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class InvoiceDto {

    private String customerName;
    private LocalDate purchaseDate;
    private Car car;
    private BigDecimal salesPrice;
    private BigDecimal taxRate;

}
