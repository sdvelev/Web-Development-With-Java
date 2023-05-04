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

    @JsonProperty("id")
    private Long id;

   // @JsonProperty("dealershipName")
    @NotBlank(message = "Name should exist")
    private String name;

    private String address;

    private String phoneNumber;

    @NotBlank(message = "Email should not be blank")
    private String email;
}
