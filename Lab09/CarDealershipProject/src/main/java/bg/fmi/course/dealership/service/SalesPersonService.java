package bg.fmi.course.dealership.service;

import bg.fmi.course.dealership.dto.CarDto;
import bg.fmi.course.dealership.dto.SalesPersonDto;
import bg.fmi.course.dealership.mapper.SalesPersonMapper;
import bg.fmi.course.dealership.model.Car;
import bg.fmi.course.dealership.model.Dealership;
import bg.fmi.course.dealership.model.Sale;
import bg.fmi.course.dealership.model.SalesPerson;
import bg.fmi.course.dealership.repository.SalesPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class SalesPersonService {

    private final SalesPersonRepository salesPersonRepository;
    private final SalesPersonMapper salesPersonMapper;

    @Autowired
    public SalesPersonService(SalesPersonRepository salesPersonRepository, SalesPersonMapper salesPersonMapper) {
        this.salesPersonRepository = salesPersonRepository;
        this.salesPersonMapper = salesPersonMapper;
    }

    public List<SalesPerson> getSalesPeople() {
        return salesPersonRepository.findAll();
    }

    public Long addSalesPerson(SalesPerson salesPerson) {
        if (salesPerson == null) {
            throw new IllegalArgumentException("Given salesPerson cannot be null");
        }
        return salesPersonRepository.save(salesPerson).getId();
    }
    public void deleteSalesPerson(SalesPerson salesPerson) {
        salesPersonRepository.delete(salesPerson);
    }

    public SalesPerson constructSalesPersonEntityBy(SalesPersonDto salesPersonDto) {
        return salesPersonMapper.toEntity(salesPersonDto);
    }

    public List<SalesPerson> searchSalesPeople(String name, String email) {
        return salesPersonRepository.findByNameAndEmail(name, email);
    }
}
