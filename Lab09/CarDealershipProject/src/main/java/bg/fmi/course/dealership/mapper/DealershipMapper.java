package bg.fmi.course.dealership.mapper;

import bg.fmi.course.dealership.dto.CarDto;
import bg.fmi.course.dealership.dto.DealershipDto;
import bg.fmi.course.dealership.model.Car;
import bg.fmi.course.dealership.model.Dealership;
import bg.fmi.course.dealership.model.Sale;

public class DealershipMapper {

    public DealershipDto toDto(Dealership entity) {
        return DealershipDto.builder()
            .id(entity.getId())
            .name(entity.getName())
            .address(entity.getAddress())
            .phoneNumber(entity.getPhoneNumber())
            .email(entity.getEmail())
            .build();
    }

    public Dealership toEntity(DealershipDto dealershipDto) {
        return Dealership.builder()
            .id(dealershipDto.getId())
            .address(dealershipDto.getAddress())
            .email(dealershipDto.getEmail())
            .name(dealershipDto.getName())
            .phoneNumber(dealershipDto.getPhoneNumber())
            .build();
    }

}
