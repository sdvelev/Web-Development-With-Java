package bg.fmi.course.dealership.mapper;

import bg.fmi.course.dealership.dto.CarDto;
import bg.fmi.course.dealership.dto.DealershipDto;
import bg.fmi.course.dealership.model.Car;
import bg.fmi.course.dealership.model.Dealership;
import bg.fmi.course.dealership.model.Sale;
import bg.fmi.course.dealership.model.SalesPerson;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDto toDto(Car entity) {
        return CarDto.builder()
            .id(entity.getId())
            .dealershipId(entity.getDealership().getId())
            .saleId(entity.getSale().getId())
            .make(entity.getMake())
            .model(entity.getModel())
            .year(entity.getYear())
            .color(entity.getColor())
            .price(entity.getPrice())
            .build();
    }

    public Car toEntity(CarDto carDto) {
        return Car.builder()
            .id(carDto.getId())
            .color(carDto.getColor())
            .make(carDto.getMake())
            .model(carDto.getModel())
            .price(carDto.getPrice())
            .year(carDto.getYear())
            .build();
    }

    public Car toEntity(CarDto carDto, Dealership dealership) {
        return Car.builder()
            .id(carDto.getId())
            .dealership(dealership)
            .color(carDto.getColor())
            .make(carDto.getMake())
            .model(carDto.getModel())
            .price(carDto.getPrice())
            .year(carDto.getYear())
            .build();
    }

    public Car toEntity(CarDto carDto, Dealership dealership, Sale sale) {
        return Car.builder()
            .id(carDto.getId())
            .dealership(dealership)
            .sale(sale)
            .color(carDto.getColor())
            .make(carDto.getMake())
            .model(carDto.getModel())
            .price(carDto.getPrice())
            .year(carDto.getYear())
            .build();
    }

}
