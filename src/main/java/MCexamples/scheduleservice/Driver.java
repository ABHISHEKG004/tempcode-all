package MCexamples.scheduleservice;

import java.util.concurrent.TimeUnit;

public class Driver {

//    2 type of fixed delays :
//    1)wait for current task to exec and then add in queue (current time + period)
//    2)add in queue (current time + period) and then execute current task
//    we handling 1 st type
//    we didn't handle task cancel
//    we didn't handle task status

    public static void main(String[] args) {
        MySchedulerExecutorService schedulerService = new MySchedulerExecutorService(10);
//        Runnable task1 = getRunnableTask("Task1");
//        schedulerService.schedule(task1, 1, TimeUnit.SECONDS);

        Runnable task3 = getRunnableTask("Task2");
        schedulerService.scheduleWithFixedDelay(task3,4,2,TimeUnit.SECONDS);

//        Runnable task2 = getRunnableTask("Task3");
//        schedulerService.scheduleAtFixedRate(task2,1, 2, TimeUnit.SECONDS);

        schedulerService.start();
    }

    private static Runnable getRunnableTask(String s) {
        return () -> {
            System.out.println(s +" started at " + System.currentTimeMillis()/1000);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(s +" ended at " + System.currentTimeMillis()/1000);
        };
    }
}
