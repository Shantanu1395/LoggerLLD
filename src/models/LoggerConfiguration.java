package models;

import enums.LogLevel;
import interfaces.LogSink;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoggerConfiguration {
    private final Map<LogLevel, List<LogSink>> sinkMapping = new HashMap<>();

    public void addSink(LogLevel level, List<LogSink> sinks) {
        sinkMapping.put(level, sinks);
    }

    public List<LogSink> getSinksForLevel(LogLevel level) {
        return sinkMapping.getOrDefault(level, Collections.emptyList());
    }
}
