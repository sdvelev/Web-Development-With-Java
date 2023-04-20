package bg.fmi.course.wdwj.dealership.controller;

import bg.fmi.course.wdwj.dealership.model.Car;
import bg.fmi.course.wdwj.dealership.model.Invoice;
import bg.fmi.course.wdwj.dealership.service.CarService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return this.carService.getAllCars();
    }

    @PostMapping
    public void addCar(@Valid @NotNull @RequestBody Car car) {
        carService.addCar(car);
    }

    @GetMapping("/search")
    public List<Car> searchCars(@RequestParam("make") String make, @RequestParam("model") String model,
                                @RequestParam("year") int year, @RequestParam("price") BigDecimal price) {
        return this.carService.searchCars(make, model, year, price);
    }

    @DeleteMapping
    public void removeCar(@RequestParam("make") String make, @RequestParam("model") String model,
                          @RequestParam("year") int year, @RequestParam("price") BigDecimal price) {
        Car carToRemove = new Car(make, model, year, price);
        carService.removeCar(carToRemove);
    }

    @DeleteMapping("/sell")
    public Invoice sellCar(@RequestParam("make") String make, @RequestParam("model") String model,
                           @RequestParam("year") int year, @RequestParam("price") BigDecimal price,
                           @RequestParam("customerName") String customerName) {
        return carService.sellCar(new Car(make, model, year, price), customerName);
    }
}
