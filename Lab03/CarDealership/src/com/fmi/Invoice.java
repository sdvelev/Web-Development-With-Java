package com.fmi;

import java.time.LocalDate;

public class Invoice {

    private String customerName;
    private LocalDate purchaseDate;
    private Car car;
    private double salesPrice;
    private double taxRate;

    public Invoice(String customerName, LocalDate purchaseDate, Car car, double salesPrice, double taxRate) {
        this.customerName = customerName;
        this.purchaseDate = purchaseDate;
        this.car = car;
        this.salesPrice = salesPrice;
        this.taxRate = taxRate;
    }

    public double getTotalPrice() {
        return this.salesPrice * (1 + this.taxRate / 100.0);
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

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(double salesPrice) {
        this.salesPrice = salesPrice;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
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
