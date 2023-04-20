package bg.fmi.course.wdwj.dealership.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Invoice {
    private String customerName;
    private LocalDate purchaseDate;
    private Car car;
    private BigDecimal salesPrice;
    private BigDecimal taxRate;

    public Invoice(@JsonProperty("customerName") String customerName,
                   @JsonProperty("purchaseDate") LocalDate purchaseDate,
                   @JsonProperty("car") Car car,
                   @JsonProperty("salesPrice") BigDecimal salesPrice,
                   @JsonProperty("taxRate") BigDecimal taxRate) {
        this.customerName = customerName;
        this.purchaseDate = purchaseDate;
        this.car = car;
        this.salesPrice = salesPrice;
        this.taxRate = taxRate;
    }

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
    }
}
