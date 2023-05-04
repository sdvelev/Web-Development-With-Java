package bg.fmi.course.wdwj.dealership.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("dealershipId")
    private Long dealershipId;

    @JsonProperty("brand")
    private String brand;

    @JsonProperty("model")
    private String model;

    @JsonProperty("year")
    private int year;

    @JsonProperty("color")
    private String color;

    @JsonProperty("price")
    private BigDecimal price;
}
