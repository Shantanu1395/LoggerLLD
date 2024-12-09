package handlers;

import enums.LogLevel;
import interfaces.LogSink;

import java.util.List;

public class DebugHandler extends LogHandler {
    public DebugHandler(List<LogSink> sinks) {
        super(LogLevel.DEBUG, sinks);
    }
}