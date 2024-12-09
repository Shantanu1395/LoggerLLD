package handlers;

import enums.LogLevel;
import interfaces.LogSink;

import java.util.List;

public class WarnHandler extends LogHandler {
    public WarnHandler(List<LogSink> sinks) {
        super(LogLevel.WARN, sinks);
    }
}
