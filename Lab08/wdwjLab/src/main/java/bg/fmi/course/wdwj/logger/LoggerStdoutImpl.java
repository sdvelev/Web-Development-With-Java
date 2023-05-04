package bg.fmi.course.wdwj.logger;

import bg.fmi.course.wdwj.config.AppConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("local")
@Component
public class LoggerStdoutImpl implements Logger {

}
