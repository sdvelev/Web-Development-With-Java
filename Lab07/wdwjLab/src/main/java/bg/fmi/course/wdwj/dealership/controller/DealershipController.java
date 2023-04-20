package bg.fmi.course.wdwj.dealership.controller;

import bg.fmi.course.wdwj.dealership.model.Dealership;
import bg.fmi.course.wdwj.dealership.service.DealershipService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dealerships")
//@AllArgsConstructor
public class DealershipController {

    private final DealershipService dealershipService;

    @Autowired
    public DealershipController(DealershipService dealershipService) {
        this.dealershipService = dealershipService;
    }

    //@RequestMapping(HttpMethod.GET, "/dealerships") <=> @GetMapping
    @GetMapping
    public List<Dealership> getDealerships() {
        return dealershipService.getDealerships();
    }

    @GetMapping(path = "/{name}")
    public Dealership getDealershipByName(@PathVariable("name") String name) {
        return dealershipService.getDealershipByName(name);
    }

    @PostMapping
    public void addDealership(@Valid @NotNull @RequestBody Dealership dealership) {
        dealershipService.addDealership(dealership);
    }


}
