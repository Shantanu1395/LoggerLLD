package interfaces;

import models.LogMessage;

import java.util.List;

public class DatabaseSink implements LogSink {
    @Override
    public void write(List<LogMessage> messages) {
        for (LogMessage message : messages) {
            System.out.println("[Database] Writing to DB: " + message.getFormattedMessage());
        }
    }
}