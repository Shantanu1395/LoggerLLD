package models;

import handlers.LogHandler;

import java.util.concurrent.ConcurrentLinkedQueue;

public class LogBuffer {
    private final ConcurrentLinkedQueue<LogMessage> buffer; // Thread-safe buffer
    private final int bufferSize;                           // Maximum size before flushing
    private final LogHandler chain;                         // Start of the chain of responsibility

    public LogBuffer(int bufferSize, LogHandler chain) {
        this.buffer = new ConcurrentLinkedQueue<>();
        this.bufferSize = bufferSize;
        this.chain = chain;
    }

    // Add a log message to the buffer
    public void add(LogMessage message) {
        buffer.add(message);
        if (buffer.size() >= bufferSize) {
            flush(); // Flush when buffer reaches its maximum size
        }
    }

    // Flush the buffer
    public synchronized void flush() {
        while (!buffer.isEmpty()) {
            LogMessage message = buffer.poll(); // Remove messages in a thread-safe manner
            if (message != null) {
                chain.handle(message); // Pass the message through the chain
            }
        }
    }
}