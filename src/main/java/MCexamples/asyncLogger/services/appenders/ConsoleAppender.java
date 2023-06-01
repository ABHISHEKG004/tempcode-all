package MCexamples.asyncLogger.services.appenders;

import MCexamples.asyncLogger.enums.LogLevel;

import java.util.Queue;

public class ConsoleAppender extends Appender {

    public ConsoleAppender(Queue<String> logQueue, int maxQueueSize, LogLevel logLevel) {
        super(logQueue, maxQueueSize, logLevel);
    }

    @Override
    public void write(String message) {
        System.out.println("ConsoleAppender " + message);
    }
}
