package bg.fmi.course.dealership.mapper;

import bg.fmi.course.dealership.dto.CarDto;
import bg.fmi.course.dealership.dto.DealershipDto;
import bg.fmi.course.dealership.dto.SalesPersonDto;
import bg.fmi.course.dealership.model.Car;
import bg.fmi.course.dealership.model.Dealership;
import bg.fmi.course.dealership.model.Sale;
import bg.fmi.course.dealership.model.SalesPerson;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class SalesPersonMapper {

    public SalesPersonDto toDto(SalesPerson entity) {

        SalesPersonDto result = new SalesPersonDto();

        if (entity.getDealership() != null) {
            result.setDealershipId(entity.getDealership().getId());
        }

        result.setId(entity.getId());
        result.setSales(entity.getSales());
        result.setEmail(entity.getEmail());
        result.setName(entity.getName());
        result.setPhoneNumber(entity.getPhoneNumber());

        return result;
    }

    public SalesPerson toEntity(SalesPersonDto salesPersonDto, Dealership dealership, Set<Sale> sales) {

        return SalesPerson.builder()
            .id(salesPersonDto.getId())
            .dealership(dealership)
            .sales(sales)
            .email(salesPersonDto.getEmail())
            .name(salesPersonDto.getName())
            .phoneNumber(salesPersonDto.getPhoneNumber())
            .build();
    }

    public SalesPerson toEntity(SalesPersonDto salesPersonDto) {

        return SalesPerson.builder()
            .id(salesPersonDto.getId())
            .email(salesPersonDto.getEmail())
            .name(salesPersonDto.getName())
            .phoneNumber(salesPersonDto.getPhoneNumber())
            .build();
    }

    public List<SalesPersonDto> toDtoList(List<SalesPerson> salesPeople) {
        return salesPeople.stream()
            .map(this::toDto)
            .collect(Collectors.toList());
    }
}
