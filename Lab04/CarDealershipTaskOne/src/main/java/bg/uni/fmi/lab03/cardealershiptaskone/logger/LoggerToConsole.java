package bg.uni.fmi.lab03.cardealershiptaskone.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoggerToConsole implements Logger {

    private LoggerLevel loggerLevel;

    @Value("${config.logger.level}")
    private String loggingLevel;

    @Override
    public void info(Object toLog) {

        if (loggerLevel.getCode() < loggingLevel) {
            System.out.println(toLog);
        }
    }

    @Override
    public void debug(Object toLog) {

    }

    @Override
    public void trace(Object toLog) {

    }

    @Override
    public void error(Object toLog) {

    }
}
