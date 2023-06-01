package MCexamples.asyncLogger.services.appenders;

import MCexamples.asyncLogger.enums.LogLevel;
import MCexamples.asyncLogger.utils.Formatter;

import java.util.Queue;

public abstract class Appender {

    // maxSize is property of appender because we can customize queue size on the basis of appender, for ex -
    // if it is fileAppender we may want to have maxQueue size greater than consoleAppender because
    // fileSink is slower than soutSink
    private int maxSize;

    // queue is property of appender because in the end ultimately it is appender to which queue belongs
    // because it is upto appender how it wants to handle its contents present in queue
    private final Queue<String> queue;

    // logLevel is property of appender because we can customize log level on the basis of appender, for ex -
    // if it is fileAppender we may want to write both info and error logs but in case of consoleAppender we
    // just want to log error logs
    private LogLevel logLevel;

    public Appender(Queue<String> queue, int maxSize, LogLevel logLevel) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.logLevel = logLevel;
    }

    public Queue<String> getQueue() {
        return queue;
    }

    public void appendToQueue(LogLevel logLevel, String message) throws InterruptedException {

        if(logLevel.getValue()>=this.logLevel.getValue()){

            synchronized (queue) {

                while (queue.size() == maxSize) {
                    queue.wait();
                }
                String formattedMsg = Formatter.simpleFormatter(logLevel, message);
//                System.out.println("produce -> " + formattedMsg);
                queue.add(formattedMsg);
                queue.notify();
            }
        }

    }

    public abstract void write(String message);

}
