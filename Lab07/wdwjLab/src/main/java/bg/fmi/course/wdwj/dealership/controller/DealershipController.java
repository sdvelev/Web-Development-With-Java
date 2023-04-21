package bg.fmi.course.wdwj.dealership.controller;

import bg.fmi.course.wdwj.dealership.controller.validation.ApiBadRequest;
import bg.fmi.course.wdwj.dealership.dto.DealershipDto;
import bg.fmi.course.wdwj.dealership.mapper.DealershipMapper;
import bg.fmi.course.wdwj.dealership.model.Dealership;
import bg.fmi.course.wdwj.dealership.service.DealershipService;
import bg.fmi.course.wdwj.logger.Logger;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/dealerships")
//@AllArgsConstructor
public class DealershipController {

    private final DealershipService dealershipService;
    private Logger logger;

    @Autowired
    public DealershipController(DealershipService dealershipService) {
        this.dealershipService = dealershipService;
    }

    //@RequestMapping(HttpMethod.GET, "/dealerships") <=> @GetMapping
    @GetMapping
    public List<DealershipDto> getDealerships() {

        // manually
       /* return dealershipService.getDealerships()
            .stream()
            .map(currentDealership -> new DealershipDto(currentDealership.getName()))
            .collect(Collectors.toList());*/

        //with MapStruct
        return DealershipMapper.INSTANCE.toList(dealershipService.getDealerships());
    }

    @GetMapping(path = "/{name}")
    public DealershipDto getDealershipByName(@PathVariable("name") String name) {
        return new DealershipDto(dealershipService.getDealershipByName(name).getName());
    }

    @PostMapping
    public void addDealership(@Valid @RequestBody DealershipDto dealership) {
        final Dealership dealershipToCreate = new Dealership(dealership.getName());
        dealershipService.addDealership(dealershipToCreate);
    }

    @GetMapping("/sales")
    public Map<String, Integer> getSalesByMake() {
        return dealershipService.getSalesByMake();
    }

    //Might be here as well, however it will be valid only for that controller
    /*@ExceptionHandler({ApiBadRequest.class})
    public ResponseEntity<?> handleBadRequest(ApiBadRequest exception) {

        return ResponseEntity.badRequest().body(exception.getMessage() + " from advice");
    }*/
}
