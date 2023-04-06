package bg.uni.fmi.lab03.cardealershiptaskone;

import bg.uni.fmi.lab03.cardealershiptaskone.model.Car;
import bg.uni.fmi.lab03.cardealershiptaskone.model.Invoice;
import bg.uni.fmi.lab03.cardealershiptaskone.service.CarService;
import bg.uni.fmi.lab03.cardealershiptaskone.service.Dealership;
import bg.uni.fmi.lab03.cardealershiptaskone.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class CarDealershipTaskOneApplication implements CommandLineRunner {

    @Autowired
    private CarService carService;

    public static void main(String[] args) {
        SpringApplication.run(CarDealershipTaskOneApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

       /* Car a = new Car("make1", "model1", 2023, 120_000);
        Car b = new Car("make2", "model2", 2018, 60_000);
        Car c = new Car("make3", "model3", 2020, 100_000);

        CarService carService = new CarService();
        carService.addCar(a);
        carService.addCar(b);

        Invoice forA = new Invoice("customer1", LocalDate.of(2023, 3, 16), a,
            a.getPrice(), 20);
        Invoice forB = new Invoice("customer2", LocalDate.of(2023, 2, 16), b,
            b.getPrice(), 20);

        InvoiceService invoiceService = new InvoiceService();
        invoiceService.addInvoice(forA);
        invoiceService.addInvoice(forB);

        Dealership dealership = new Dealership("name", carService, invoiceService);

        dealership.addCar(c);

        System.out.println(dealership.getSalesByMake());

        dealership.sellCar(c,"customer3", 10);

        System.out.println(dealership.getSalesByMake());

        System.out.println(dealership.getTotalRevenue());*/

        System.out.println("<<<");
        carService.removeCar(new Car("", "", 2023, 40_000));
    }
}
