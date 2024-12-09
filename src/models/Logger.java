package models;

import enums.LogLevel;
import handlers.*;

public class Logger {
    private static volatile Logger instance;  // Singleton instance
    private LogHandler chain;        // Start of the chain of responsibility
    private LogBuffer buffer;        // Thread-safe buffer

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void initialize(LoggerConfiguration configuration, int bufferSize) {
        // Build the chain of responsibility
        LogHandler fatalHandler = new FatalHandler(configuration.getSinksForLevel(LogLevel.FATAL));
        LogHandler errorHandler = new ErrorHandler(configuration.getSinksForLevel(LogLevel.ERROR));
        LogHandler warnHandler = new WarnHandler(configuration.getSinksForLevel(LogLevel.WARN));
        LogHandler infoHandler = new InfoHandler(configuration.getSinksForLevel(LogLevel.INFO));
        LogHandler debugHandler = new DebugHandler(configuration.getSinksForLevel(LogLevel.DEBUG));

        // Link the handlers
        debugHandler.setNextHandler(infoHandler);
        infoHandler.setNextHandler(warnHandler);
        warnHandler.setNextHandler(errorHandler);
        errorHandler.setNextHandler(fatalHandler);

        this.chain = debugHandler;

        // Initialize buffer
        this.buffer = new LogBuffer(bufferSize, chain);
    }

    public void log(LogLevel level, String content, String namespace) {
        if (chain == null || buffer == null) {
            throw new IllegalStateException("Logger is not initialized!");
        }

        LogMessage message = new LogMessage(level, content, namespace);
        buffer.add(message); // Add the log message to the buffer
    }

    public void flush() {
        buffer.flush();
    }
}