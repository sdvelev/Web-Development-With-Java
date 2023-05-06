package bg.fmi.course.dealership.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DealershipDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("dealershipName")
    @NotBlank(message = "Name should exist")
    private String name;

    @JsonProperty("address")
    private String address;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("email")
    @NotBlank(message = "Email should not be blank")
    private String email;
}
