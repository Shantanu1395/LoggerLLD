import enums.LogLevel;
import interfaces.ConsoleSink;
import interfaces.DatabaseSink;
import interfaces.FileSink;
import models.Logger;
import models.LoggerConfiguration;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Create and configure the logger
        LoggerConfiguration configuration = new LoggerConfiguration();
        configuration.addSink(LogLevel.INFO, Arrays.asList(new ConsoleSink(), new FileSink("logs.txt")));
        configuration.addSink(LogLevel.ERROR, List.of(new DatabaseSink()));

        // Initialize logger with configuration and buffer size
        logger.initialize(configuration, 5); // Buffer size: 5

        // Log messages
        logger.log(LogLevel.DEBUG, "This is a DEBUG message.", "MainModule");
        logger.log(LogLevel.INFO, "Application started successfully.", "MainModule");
        logger.log(LogLevel.WARN, "Low disk space warning.", "SystemModule");
        logger.log(LogLevel.ERROR, "Database connection failed.", "DBModule");
        logger.log(LogLevel.FATAL, "Critical system failure!", "SystemModule");

        // Manually flush the buffer
        logger.flush();

        // Log more messages and flush again
        logger.log(LogLevel.INFO, "Another INFO message.", "MainModule");
        logger.flush();
    }
}