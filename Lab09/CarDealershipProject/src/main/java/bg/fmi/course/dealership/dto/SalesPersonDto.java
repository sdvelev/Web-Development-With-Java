package bg.fmi.course.dealership.dto;

import bg.fmi.course.dealership.model.Dealership;
import bg.fmi.course.dealership.model.Sale;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalesPersonDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("dealershipId")
    private Long dealershipId;

    @JsonProperty("sales")
    private Set<Sale> sales;

    @JsonProperty("email")
    private String email;

    @JsonProperty("name")
    private String name;

    @JsonProperty("phoneNumber")
    private String phoneNumber;
}
