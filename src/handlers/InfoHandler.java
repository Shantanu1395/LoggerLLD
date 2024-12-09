package handlers;

import enums.LogLevel;
import interfaces.LogSink;

import java.util.List;

public class InfoHandler extends LogHandler {
    public InfoHandler(List<LogSink> sinks) {
        super(LogLevel.INFO, sinks);
    }
}