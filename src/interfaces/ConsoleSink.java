package interfaces;

import models.LogMessage;

import java.util.List;

public class ConsoleSink implements LogSink {
    @Override
    public void write(List<LogMessage> messages) {
        for (LogMessage message : messages) {
            System.out.println("[Console] " + message.getFormattedMessage());
        }
    }
}