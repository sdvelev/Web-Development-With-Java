package bg.fmi.course.wdwj.logger;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("local")
@Component
public class LoggerStdoutImpl implements Logger {

    @Value("${profile.logger.level}")
    private String loggingLevelString;

    private LoggerLevel loggerLevel;

    @PostConstruct
    private void LoggerStdoutPostConstruct() {
        loggerLevel = LoggerLevel.valueOf(loggingLevelString);
    }


    @Override
    public void info(Object toLog) {
        System.out.println(">>>>>> [info] ->" + toLog);
    }

    @Override
    public void debug(Object toLog) {
        if (loggerLevel.getCode().compareTo(LoggerLevel.DEBUG.getCode()) <= 0){
            System.out.println(">>>>>>>> [DEBUG] ->" + toLog);
        }
    }

    @Override
    public void trace(Object toLog) {
        if (loggerLevel.getCode().compareTo(LoggerLevel.TRACE.getCode()) <= 0){
            System.out.println(">>>>>>>> [TRACE] ->" + toLog);
        }
    }

    @Override
    public void error(Object toLog) {
        System.out.println(">>>>>>>> [ERROR] ->" + toLog);
    }
}
