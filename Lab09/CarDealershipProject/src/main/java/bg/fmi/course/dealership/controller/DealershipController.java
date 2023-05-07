package bg.fmi.course.dealership.controller;

import bg.fmi.course.dealership.dto.CarDto;
import bg.fmi.course.dealership.dto.DealershipDto;
import bg.fmi.course.dealership.dto.SalesPersonDto;
import bg.fmi.course.dealership.mapper.DealershipMapper;
import bg.fmi.course.dealership.service.DealershipService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dealerships")
public class DealershipController {

    private final DealershipService dealershipService;
    private final DealershipMapper dealershipMapper;

    @Autowired
    public DealershipController(DealershipService dealershipService, DealershipMapper dealershipMapper) {
        this.dealershipService = dealershipService;
        this.dealershipMapper = dealershipMapper;
    }

    @GetMapping
    public List<DealershipDto> getDealerships() {
        return dealershipMapper.toDtoList(dealershipService.getDealerships());
    }

    @PostMapping
    public void addDealership(@Valid @NotNull @RequestBody DealershipDto dealershipDto) {
        dealershipService.addDealership(dealershipMapper.toEntity(dealershipDto));
    }

    @PostMapping(path = "/cars")
    public Long addCarToDealership(@Valid @NotNull @RequestBody CarDto carDto) {
        return dealershipService.addCarToDealership(carDto.getDealershipId(), carDto);
    }

    @PostMapping(path = "/salesPeople")
    public Long addSalesPersonToDealership(@Valid @NotNull @RequestBody SalesPersonDto salesPersonDto) {
        return dealershipService.addSalesPersonToDealership(salesPersonDto.getDealershipId(), salesPersonDto);
    }
}
