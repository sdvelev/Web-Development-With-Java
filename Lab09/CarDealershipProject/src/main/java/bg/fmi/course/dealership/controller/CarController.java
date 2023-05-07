package bg.fmi.course.dealership.controller;

import bg.fmi.course.dealership.ResourceNotFoundException;
import bg.fmi.course.dealership.dto.CarDto;
import bg.fmi.course.dealership.mapper.CarMapper;
import bg.fmi.course.dealership.model.Car;
import bg.fmi.course.dealership.service.CarService;
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
@RequestMapping(path = "/cars")
public class CarController {

    private final CarService carService;
    private final CarMapper carMapper;

    @Autowired
    public CarController(CarService carService, CarMapper carMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @GetMapping
    public List<CarDto> getAllCars() {

        final List<Car> carsList = carService.getAllCars();

        return carsList.stream()
            .map(carMapper::toDto)
            .collect(Collectors.toList());
    }

    @PostMapping
    public Long addCar(@Valid @NotNull @RequestBody CarDto car) {
        return carService.addCar(carMapper.toEntity(car));
    }

    @GetMapping("/search")
    public List<CarDto> searchCars(@RequestParam("make") String make, @RequestParam("model") String model,
                                   @RequestParam("year") int year, @RequestParam("price") double price) {
        return this.carService.searchCarsPriceLessThan(make, model, year, price)
            .stream()
            .map(carMapper::toDto)
            .collect(Collectors.toList());
    }

    @DeleteMapping
    public void removeCar(@RequestParam("make") String make, @RequestParam("model") String model,
                          @RequestParam("year") int year, @RequestParam("price") double price) {
        List<Car> result = carService.searchCars(make, model, year, price);

        if (result.isEmpty()) {
            throw new ResourceNotFoundException("There is not such a car");
        }

        for (Car carToDelete : result) {
            carService.removeCar(carToDelete);
        }
    }

    /*@DeleteMapping("/sell")
    public Invoice sellCar(@RequestParam("make") String make, @RequestParam("model") String model,
                           @RequestParam("year") int year, @RequestParam("price") BigDecimal price,
                           @RequestParam("customerName") String customerName) {
        return carService.sellCar(new Car(make, model, year, price), customerName);
    }*/
}
