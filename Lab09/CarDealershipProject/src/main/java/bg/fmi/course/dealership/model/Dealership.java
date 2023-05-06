package bg.fmi.course.dealership.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "dealership", uniqueConstraints = @UniqueConstraint(name = "unique_email", columnNames = {"email"}))
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dealership {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @OneToMany(mappedBy = "dealership")
    private Set<Car> cars;

    @OneToMany(mappedBy = "dealership")
    private Set<SalesPerson> salesPeople;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dealership that = (Dealership) o;
        return Objects.equals(address, that.address) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, name);
    }
}
