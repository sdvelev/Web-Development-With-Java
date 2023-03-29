package bg.uni.fmi.lab03.cardealershiptaskone.service;

import bg.uni.fmi.lab03.cardealershiptaskone.model.Car;
import bg.uni.fmi.lab03.cardealershiptaskone.model.Invoice;
import bg.uni.fmi.lab03.cardealershiptaskone.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    public CarService() {

        this.carRepository = new CarRepository();
    }

    @Autowired
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
}
