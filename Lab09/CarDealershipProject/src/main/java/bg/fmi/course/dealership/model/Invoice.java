package bg.fmi.course.dealership.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Table(name = "invoice")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "base_price")
    private BigDecimal basePrice;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "invoice_date")
    private LocalDate invoiceDate;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "tax_rate")
    private BigDecimal taxRate;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @OneToOne(mappedBy = "invoice")
    private Sale sale;
}
