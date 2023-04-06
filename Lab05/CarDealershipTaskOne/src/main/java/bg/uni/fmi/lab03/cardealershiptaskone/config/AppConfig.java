package bg.uni.fmi.lab03.cardealershiptaskone.config;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@ConfigurationProperties(prefix = "config")
@Configuration
@Data
public class AppConfig {

    private LoggerConfig logger = new LoggerConfig();

    private Dealership dealership  = new Dealership();

    @Data
    public class LoggerConfig {
        private String level;
        private String name;

//        @DateTimeFormat(pattern = "yyyy-MM-dd")
//        private LocalDate myDate;
    }

    @Data
    public class Dealership {
        private Integer maxTaxRate;
        private Map<Integer, String> numbers;
    }
}
