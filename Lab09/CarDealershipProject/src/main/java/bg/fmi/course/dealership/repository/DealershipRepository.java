package bg.fmi.course.dealership.repository;

import bg.fmi.course.dealership.dto.DealershipDto;
import bg.fmi.course.dealership.model.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealershipRepository extends JpaRepository<Dealership, Long> {
}
