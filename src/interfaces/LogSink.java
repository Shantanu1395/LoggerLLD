package interfaces;

import models.LogMessage;

import java.util.List;

public interface LogSink {
    void write(List<LogMessage> messages);
}