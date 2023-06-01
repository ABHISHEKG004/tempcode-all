package MCexamples.asyncLogger.driver;


import MCexamples.asyncLogger.enums.LogLevel;
import MCexamples.asyncLogger.services.Logger;
import MCexamples.asyncLogger.services.appenders.Appender;
import MCexamples.asyncLogger.services.appenders.ConsoleAppender;
import MCexamples.asyncLogger.services.appenders.TestAppender;

import java.util.ArrayList;
import java.util.LinkedList;


public class MainClass {

    public static void main(String[] args) {

        int maxQueueSize = 5;
        LogLevel logLevel  = LogLevel.ALL;
        ArrayList<Appender> appenders = new ArrayList<Appender>();

        //2 separate queues (new LinkedList<String>()) bcoz both appenders require to consume all logs, else we can use common queue
        appenders.add(new ConsoleAppender(new LinkedList<String>(), maxQueueSize, logLevel));
        appenders.add(new TestAppender(new LinkedList<String>(), maxQueueSize, LogLevel.ERROR));

        Logger logger = new Logger(appenders);
        logger.init();

        for (int i=0;i<5;i++) {
            logger.info("Info msg " + i);
            logger.error("Error msg " + i);
        }

//        ************** Logger2 **************

//        ArrayList<Appender> sinks2 = new ArrayList<Appender>();
//        sinks2.add(new ConsoleAppender(new LinkedList<String>(), 4, LogLevel.ERROR));
//
//        Logger logger2 = new Logger(sinks2);
//        logger2.init();
//
//        for (int i=0;i<10;i++) {
//            logger2.info("Logger2 Info msg " + i);
//            logger2.error("Logger2 Error msg " + i);
//        }
    }

}
