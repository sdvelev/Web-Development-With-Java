package bg.fmi.course.wdwj.dealership.controller;

import bg.fmi.course.wdwj.dealership.dto.CarDto;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarDto> getAllCars() {
        return this.carService.getAllCars().stream()
            .map(car -> new CarDto(car.getMake(), car.getModel(), car.getYear(), car.getPrice()))
            .collect(Collectors.toList());
    }

    @PostMapping
    public void addCar(@Valid @NotNull @RequestBody CarDto car) {
        carService.addCar(new Car(car.getMake(), car.getModel(), car.getYear(), car.getPrice()));
    }

    @GetMapping("/search")
    public List<CarDto> searchCars(@RequestParam("make") String make, @RequestParam("model") String model,
                                @RequestParam("year") int year, @RequestParam("price") BigDecimal price) {
        return this.carService.searchCars(make, model, year, price)
            .stream()
            .map(car -> new CarDto(car.getMake(), car.getModel(), car.getYear(), car.getPrice()))
            .collect(Collectors.toList());
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
