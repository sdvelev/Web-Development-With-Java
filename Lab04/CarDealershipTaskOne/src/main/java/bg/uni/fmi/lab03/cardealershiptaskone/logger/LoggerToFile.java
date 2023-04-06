package bg.uni.fmi.lab03.cardealershiptaskone.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class LoggerToFile implements Logger {

    private void logInformation(Object toLog, LoggerLevel currentLoggerLevel) {
        File log = new File("log.txt");
        try (PrintWriter out = new PrintWriter(new FileWriter(log, true))) {
            out.println(new Date() + " [" + currentLoggerLevel.getLabel() + "] - " + toLog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void info(Object toLog) {

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
