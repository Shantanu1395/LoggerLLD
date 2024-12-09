package interfaces;

import models.LogMessage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileSink implements LogSink {
    private final String fileName;

    public FileSink(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(List<LogMessage> messages) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            for (LogMessage message : messages) {
                writer.write(message.getFormattedMessage() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}