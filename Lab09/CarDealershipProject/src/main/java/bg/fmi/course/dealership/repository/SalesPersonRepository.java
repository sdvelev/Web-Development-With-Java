package bg.fmi.course.dealership.repository;

import bg.fmi.course.dealership.model.SalesPerson;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesPersonRepository extends JpaRepository<SalesPerson, Long> {
}
