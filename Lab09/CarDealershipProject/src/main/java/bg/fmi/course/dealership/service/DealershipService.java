package bg.fmi.course.dealership.service;

import bg.fmi.course.dealership.ResourceNotFoundException;
import bg.fmi.course.dealership.dto.CarDto;
import bg.fmi.course.dealership.mapper.CarMapper;
import bg.fmi.course.dealership.mapper.DealershipMapper;
import bg.fmi.course.dealership.model.Car;
import bg.fmi.course.dealership.model.Dealership;
import bg.fmi.course.dealership.repository.DealershipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.stream.Collectors;

@Service
public class DealershipService {

    private final CarService carService;
    private final InvoiceService invoiceService;
    private final DealershipRepository dealershipRepository;

    @Autowired
    public DealershipService(CarService carService, InvoiceService invoiceService,
                             DealershipRepository dealershipRepository) {
        this.carService = carService;
        this.invoiceService = invoiceService;
        this.dealershipRepository = dealershipRepository;
    }

    public boolean addDealership(Dealership dealership) {
        if (dealership == null) {
            throw new IllegalArgumentException("Dealership cannot be null");
        }

        final List<Dealership> dealershipsList = dealershipRepository.findAll();
        Set<Dealership> dealershipSet = new HashSet<>(dealershipsList);

        if (dealershipSet.contains(dealership)) {
            return false;
        }

        dealershipRepository.save(dealership);
        return true;
    }

    public Dealership getDealershipByName(String name) {

        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null");
        }

        Optional<Dealership> result = dealershipRepository.findByName(name);

        if (!result.isPresent()) {
            throw new ResourceNotFoundException("Dealership with such a name is missing");
        }

        return result.get();
    }

    public List<Dealership> getDealerships() {
        return dealershipRepository.findAll();
    }

    public Long addCarToDealership(Long id, CarDto carDto) {

        Optional<Dealership> dealershipResult = dealershipRepository.findById(id);

        if (!dealershipResult.isPresent()) {
            throw new ResourceNotFoundException("Dealership with such a name is missing");
        }

        Dealership dealershipToWorkWith = dealershipResult.get();
        Car carToSave = carService.constructCarEntityBy(carDto, dealershipToWorkWith);

        dealershipToWorkWith.getCars().add(carToSave);
        return carService.addCar(carToSave);
    }

    /*  public void sellCar(Car car, String customerName) {
        Invoice invoice = new Invoice(customerName, LocalDate.now(), car, car.getPrice(), BigDecimal.valueOf(0.2));
        invoiceService.addInvoice(invoice);
        carService.removeCar(car);
        System.out.println("Car sold to " + customerName + " for " + invoice.getTotalPrice());
    }*/

    /*public void printInvoice(Invoice invoice) {
        System.out.println(invoice.toString());
    }
    public Map<String, Integer> getSalesByMake() {
        List<Invoice> invoices = invoiceService.getInvoiceHistory();
        Map<String, Integer> salesByMake = new HashMap<>();
        for (Invoice invoice : invoices) {
            String make = invoice.getCar().getMake();
            salesByMake.put(make, salesByMake.getOrDefault(make, 0) + 1);
        }
        return salesByMake;
    }
    public double getTotalRevenue() {
        List<Invoice> invoices = invoiceService.getInvoiceHistory();
        double totalRevenue = 0;
        for (Invoice invoice : invoices) {
            totalRevenue += invoice.getTotalPrice().doubleValue();
        }
        return totalRevenue;
    }*/

}
