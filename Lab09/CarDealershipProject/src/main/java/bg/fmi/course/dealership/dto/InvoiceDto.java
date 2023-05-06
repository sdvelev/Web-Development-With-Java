package bg.fmi.course.dealership.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("invoiceNumber")
    private String invoiceNumber;

    @JsonProperty("customerName")
    private String customerName;

    @JsonProperty("invoiceDate")
    private LocalDate invoiceDate;

    @JsonProperty("basePrice")
    private BigDecimal basePrice;

    @JsonProperty("taxRate")
    private BigDecimal taxRate;

    @JsonProperty("totalPrice")
    private BigDecimal totalPrice;

    @JsonProperty("saleId")
    private Long saleId;

}
