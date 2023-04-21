package bg.fmi.course.wdwj.dealership.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DealershipDto {

   // @JsonProperty("dealershipName")
    @NotBlank(message = "Name should exist")
    private String name;
}
