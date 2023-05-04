package bg.fmi.course.wdwj.dealership.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String invoiceNumber;

    @Column
    private String customerName;

    @Column
    private LocalDate invoiceDate;

    @Column
    private BigDecimal basePrice;

    @Column
    private BigDecimal taxRate;

    @Column
    private BigDecimal totalPrice;
   /* public Invoice(@JsonProperty("customerName") String customerName,
                   @JsonProperty("purchaseDate") LocalDate purchaseDate,
                   @JsonProperty("car") Car car,
                   @JsonProperty("salesPrice") BigDecimal salesPrice,
                   @JsonProperty("taxRate") BigDecimal taxRate) {
        this.customerName = customerName;
        this.purchaseDate = purchaseDate;
        this.car = car;
        this.salesPrice = salesPrice;
        this.taxRate = taxRate;
    }*/
/*
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public BigDecimal getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(BigDecimal salesPrice) {
        this.salesPrice = salesPrice;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal tax = salesPrice.multiply(taxRate);
        return salesPrice.add(tax);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "customerName='" + customerName + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", car=" + car +
                ", salesPrice=" + salesPrice +
                ", taxRate=" + taxRate +
                '}';
    }*/
}
