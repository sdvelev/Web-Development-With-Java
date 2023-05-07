package bg.fmi.course.dealership.repository;

import bg.fmi.course.dealership.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    public List<Car> findByMakeAndModelAndYearAndPriceLessThanEqual(String make, String model, int year,
                                                                    BigDecimal price);

}
