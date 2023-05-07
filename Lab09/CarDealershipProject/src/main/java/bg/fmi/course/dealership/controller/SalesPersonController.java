package bg.fmi.course.dealership.controller;

import bg.fmi.course.dealership.ResourceNotFoundException;
import bg.fmi.course.dealership.dto.DealershipDto;
import bg.fmi.course.dealership.dto.SalesPersonDto;
import bg.fmi.course.dealership.mapper.SalesPersonMapper;
import bg.fmi.course.dealership.model.Car;
import bg.fmi.course.dealership.model.SalesPerson;
import bg.fmi.course.dealership.service.SalesPersonService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/salesPeople")
public class SalesPersonController {

    private final SalesPersonService salesPersonService;
    private final SalesPersonMapper salesPersonMapper;

    @Autowired
    public SalesPersonController(SalesPersonService salesPersonService, SalesPersonMapper salesPersonMapper) {
        this.salesPersonService = salesPersonService;
        this.salesPersonMapper = salesPersonMapper;
    }

    @GetMapping
    public List<SalesPersonDto> getSalesPerson() {
        return salesPersonMapper.toDtoList(salesPersonService.getSalesPeople());
    }

    @PostMapping
    public void addSalesPerson(@Valid @NotNull @RequestBody SalesPersonDto salesPersonDto) {
        salesPersonService.addSalesPerson(salesPersonMapper.toEntity(salesPersonDto));
    }

    @DeleteMapping
    public void removeSalesPerson(@RequestParam("name") String name, @RequestParam("email") String email) {
        List<SalesPerson> result = salesPersonService.searchSalesPeople(name, email);

        if (result.isEmpty()) {
            throw new ResourceNotFoundException("There is not such a car");
        }

        for (SalesPerson salesPersonToDelete : result) {
            salesPersonService.deleteSalesPerson(salesPersonToDelete);
        }
    }

}
