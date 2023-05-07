package bg.fmi.course.dealership.repository;

import bg.fmi.course.dealership.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findInvoicesByTotalPriceLessThan(BigDecimal price);
}
