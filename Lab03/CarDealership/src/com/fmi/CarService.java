package com.fmi;

import com.sun.security.jgss.InquireSecContextPermission;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void addCar(Car carToAdd) {
        this.carRepository.addCar(carToAdd);
    }

    public void removeCar(Car carToRemove) {
        this.carRepository.removeCar(carToRemove);
    }

    public List<Car> searchCars(String make, String model, int year, double price) {
        return this.carRepository.searchCars(make, model, year, price);
    }

    public List<Car> getAllCars() {
        return this.carRepository.getAllCars();
    }

    public Invoice sellCar(Car car, String customerName, double taxRate) {
        return new Invoice(customerName, LocalDate.now(), car, car.getPrice(), taxRate);
    }

    public void printInvoice(Invoice invoice) {
        System.out.println(invoice);
    }

}
