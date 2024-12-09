package handlers;

import enums.LogLevel;
import interfaces.LogSink;
import models.LogMessage;

import java.util.Collections;
import java.util.List;


public abstract class LogHandler {
    protected LogHandler nextHandler;  // Next handler in the chain
    protected LogLevel logLevel;       // Log level for this handler
    protected List<LogSink> sinks;     // Sinks for this log level

    public LogHandler(LogLevel logLevel, List<LogSink> sinks) {
        this.logLevel = logLevel;
        this.sinks = (sinks != null) ? sinks : Collections.emptyList();
    }

    public void setNextHandler(LogHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handle(LogMessage message) {
        if (message.getLevel().getLevel() >= logLevel.getLevel()) {
            process(message);
        }
        if (nextHandler != null) {
            nextHandler.handle(message);
        }
    }

    protected void process(LogMessage message) {
        for (LogSink sink : sinks) {
            sink.write(List.of(message));
        }
    }
}