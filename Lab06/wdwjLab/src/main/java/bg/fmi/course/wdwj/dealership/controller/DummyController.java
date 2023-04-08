package bg.fmi.course.wdwj.dealership.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
@RequestMapping("/dummy")
public class DummyController {

    @GetMapping("/test")
    public String dummy() {
        return "hello, dummy TEST";
    }

}
