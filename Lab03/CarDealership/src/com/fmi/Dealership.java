package com.fmi;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dealership {

    private final String name;
    private final CarService carService;
    private final InvoiceService invoiceService;

    public Dealership(String name) {
        this.name = name;
        this.carService = new CarService(new CarRepository());
        this.invoiceService = new InvoiceService(new InvoiceRepository());
    }

    public Dealership(String name, CarService carService, InvoiceService invoiceService) {
        this.name = name;
        this.carService = carService;
        this.invoiceService = invoiceService;
    }

    public void addCar(Car car) {
        this.carService.addCar(car);
    }

    public void removeCar(Car car) {
        this.carService.removeCar(car);
    }

    public List<Car> searchCars(String make, String model, int year, double price) {
        return this.carService.searchCars(make, model, year, price);
    }

    public void sellCar(Car car, String customerName, double taxRate) {
        this.invoiceService.addInvoice(this.carService.sellCar(car, customerName, taxRate));
    }

    public void printInvoice(Invoice invoice) {
        this.invoiceService.printInvoice(invoice);
    }

    public Map<String, Integer> getSalesByMake() {

        Map<String, Integer> toReturnMap = new HashMap<>();

        for (Invoice currentInvoice : this.invoiceService.getInvoiceHistory()) {

            if (!toReturnMap.containsKey(currentInvoice.getCar().getMake())) {
                toReturnMap.put(currentInvoice.getCar().getMake(), 1);
            } else {
                toReturnMap.put(currentInvoice.getCar().getMake(), toReturnMap.get(currentInvoice.getCar().getMake()) + 1);
            }
        }

        return toReturnMap;
    }

    public double getTotalRevenue() {

        return this.invoiceService.calculateTotalPrice();
    }

    public static void main(String[] args) {

        Car a = new Car("make1", "model1", 2023, 120_000);
        Car b = new Car("make2", "model2", 2018, 60_000);
        Car c = new Car("make3", "model3", 2020, 100_000);

        CarService carService = new CarService();
        carService.addCar(a);
        carService.addCar(b);

        Invoice forA = new Invoice("customer1", LocalDate.of(2023, 3, 16), a,
            a.getPrice(), 20);
        Invoice forB = new Invoice("customer2", LocalDate.of(2023, 2, 16), b,
            b.getPrice(), 20);

        InvoiceService invoiceService = new InvoiceService();
        invoiceService.addInvoice(forA);
        invoiceService.addInvoice(forB);

        Dealership dealership = new Dealership("name", carService, invoiceService);

        dealership.addCar(c);

        System.out.println(dealership.getSalesByMake());

        dealership.sellCar(c,"customer3", 10);

        System.out.println(dealership.getSalesByMake());

        System.out.println(dealership.getTotalRevenue());
    }

}
