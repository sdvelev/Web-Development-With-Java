package bg.fmi.course.wdwj.dealership.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Dealership {
    private String name;

    public Dealership(@JsonProperty("name") String name) {
        this.name = name;
    }
}

