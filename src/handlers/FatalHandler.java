package handlers;

import enums.LogLevel;
import interfaces.LogSink;

import java.util.List;

public class FatalHandler extends LogHandler {
    public FatalHandler(List<LogSink> sinks) {
        super(LogLevel.FATAL, sinks);
    }
}
