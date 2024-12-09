package handlers;

import enums.LogLevel;
import interfaces.LogSink;

import java.util.List;

public class ErrorHandler extends LogHandler {
    public ErrorHandler(List<LogSink> sinks) {
        super(LogLevel.ERROR, sinks);
    }
}
