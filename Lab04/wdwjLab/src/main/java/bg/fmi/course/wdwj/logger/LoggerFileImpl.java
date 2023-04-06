package bg.fmi.course.wdwj.logger;

import org.apache.commons.logging.Log;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Profile("dev")
@Component
public class LoggerFileImpl implements Logger {

   // private ApConfig

    private final Log

    private void logToFile() {


    }


    @Override
    public void info(Object toLog) {

    }

    @Override
    public void debug(Object toLog) {

    }

    @Override
    public void trace(Object toLog) {

        //logInformation(toLog, LoggerLevel.TRACE)
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

    private void logInformation(Object toLog, LoggerLevel currentLoggerLevel) {
        File log = new File("log.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(log, true))) {
            out.println(new Date() + " [" + currentLoggerLevel.getLabel() + "] - " + toLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
