package bg.fmi.course.dealership.service;

import bg.fmi.course.dealership.dto.CarDto;
import bg.fmi.course.dealership.mapper.CarMapper;
import bg.fmi.course.dealership.model.Car;
import bg.fmi.course.dealership.model.Dealership;
import bg.fmi.course.dealership.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public CarService(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public Long addCar(Car car) {
        return carRepository.save(car).getId();
    }

    public void removeCar(Car car) {
        carRepository.delete(car);
    }

    public List<Car> searchCars(String brand, String model, int year, double price) {
        return carRepository.findByMakeAndModelAndYearAndPriceLessThanEqual(brand, model, year, new BigDecimal(price));
    }

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car constructCarEntityBy(CarDto carDto, Dealership dealership) {
        return carMapper.toEntity(carDto, dealership);
    }

    /*
    public Invoice sellCar(Car car, String customerName) {
        Invoice invoice = new Invoice(customerName, LocalDate.now(), car, car.getPrice(), BigDecimal.valueOf(0.2));
        carRepository.removeCar(car);
        return invoice;*/
}
