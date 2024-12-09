package models;

import enums.LogLevel;

public class LogMessage {
    private final LogLevel level;
    private final String content;
    private final String namespace;
    private final String timestamp;

    public LogMessage(LogLevel level, String content, String namespace) {
        this.level = level;
        this.content = content;
        this.namespace = namespace;
        this.timestamp = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getFormattedMessage() {
        return String.format("%s [%s] [%s] %s", timestamp, level.name(), namespace, content);
    }
}