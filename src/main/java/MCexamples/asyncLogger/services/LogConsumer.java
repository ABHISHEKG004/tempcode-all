package MCexamples.asyncLogger.services;

import MCexamples.asyncLogger.services.appenders.Appender;

public class LogConsumer implements Runnable {

    private Appender appender;

    public LogConsumer(Appender appender) {
        this.appender = appender;
    }

    public void run() {
        while (true) {
            String message;
            synchronized (appender.getQueue()) {
                while (appender.getQueue().isEmpty()) {
                    try {
                        appender.getQueue().wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                message = appender.getQueue().poll();
                appender.getQueue().notify();
            }
            appender.write(message);
        }
    }
}
