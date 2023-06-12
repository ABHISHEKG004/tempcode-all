package MCexamples.scheduleservice;

import java.util.PriorityQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MySchedulerExecutorService implements ScheduledExecutorService{

    private final PriorityQueue<MyScheduledTask> taskQueue;
    private final ThreadPoolExecutor workerExecutor ;

    public MySchedulerExecutorService(int workerThreadSize) {
        this.taskQueue = new PriorityQueue<>(new MyScheduledTaskComparator());
        workerExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(workerThreadSize);
    }

    public void start(){
        long timeToSleep =0;
        while (true){

            try{

                boolean taskFired;

                synchronized(taskQueue) {

                    while (taskQueue.isEmpty()) {
                        taskQueue.wait();
                    }

                    while (!taskQueue.isEmpty()) {
                        timeToSleep = taskQueue.peek().getScheduledTime() - System.currentTimeMillis();
                        if (timeToSleep <= 0) {
                            break;
                        }
                        taskQueue.wait(timeToSleep);
                    }
                    MyScheduledTask task = taskQueue.poll();

//                    taskFired = (executionTime<=currentTime);
                    workerExecutor.submit(task.getRunnable());

                    long newScheduledTime = 0;
                    switch (task.getTaskType()) {
                        case 1:
                            //this type of task will be executed only once
//                            workerExecutor.submit(task.getRunnable());
                            break;
                        case 2:
//                        Ideally it should be -> task.getScheduledTime() + task.getUnit().toMillis(task.getPeriod());
                            newScheduledTime = task.getScheduledTime() + task.getUnit().toMillis(task.getPeriod());
                            task.setScheduledTime(newScheduledTime);
                            taskQueue.add(task);
                            break;
                        case 3:
//                            Future<?> future = workerExecutor.submit(task.getRunnable());
//                            future.get(); // will wait for the finish of this task
//                            newScheduledTime = System.currentTimeMillis() + task.getUnit().toMillis(task.getPeriod());
//                            task.setScheduledTime(newScheduledTime);
//                            taskQueue.add(task);
                            break;
                    }
                }
            }catch (Exception e){
                System.out.println("some thing wrong in start");
                e.printStackTrace();
            }
        }

    }

    /**
     * Creates and executes a one-shot action that becomes enabled after the given delay.
     */
    public void schedule(Runnable command, long delay, TimeUnit unit) {

        try{
            synchronized(this.taskQueue) {
                long scheduledTime = System.currentTimeMillis() + unit.toMillis(delay);
                MyScheduledTask task = new MyScheduledTask(command, scheduledTime, 1, null, unit);
                taskQueue.add(task);
                this.taskQueue.notifyAll();
            }
        }catch (Exception e){
            System.out.println("some thing wrong in scheduling task type 1");
        }
    }

    /**
     * Creates and executes a periodic action that becomes enabled first after the given initial delay, and
     * subsequently with the given period; that is executions will commence after initialDelay then
     * initialDelay+period, then initialDelay + 2 * period, and so on.
     */
    public void scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
        try{
            synchronized(this.taskQueue) {
                long scheduledTime = System.currentTimeMillis() + unit.toMillis(initialDelay);
                MyScheduledTask task = new MyScheduledTask(command, scheduledTime, 2, period, unit);
                taskQueue.add(task);
                this.taskQueue.notifyAll();
            }
        }catch (Exception e){
            System.out.println("some thing wrong in scheduling task type 2");
        }
    }

    /*
     * Creates and executes a periodic action that becomes enabled first after the given initial delay, and
     * subsequently with the given delay between the termination of one execution and the commencement of the next.
     */
    public void scheduleWithFixedDelay(Runnable command, long initialDelay, long period, TimeUnit unit) {
        try{
            synchronized(this.taskQueue){

                long scheduledTime = System.currentTimeMillis() + unit.toMillis(initialDelay);

                Runnable handleDelayNonBlockingMain = new Runnable() {

                    // i guess issue is happening due to mulitple thread and thus no honouring delay tasks
                    //edit : now working after ading taskQueue.notifyAll();
                    @Override
                    public void run() {

                        command.run();

                        System.out.println("special 1");

                        synchronized(taskQueue) {

                            long newScheduledTime = System.currentTimeMillis() + unit.toMillis(period);

                            System.out.println("special 1 newScheduledTime -> " + newScheduledTime/1000 + " period -> " + period);
//                            this.setScheduledTime(newScheduledTime);
                            MyScheduledTask task = new MyScheduledTask(this, newScheduledTime, 3, period, unit);
                            taskQueue.add(task);
                            System.out.println("special 1 added");
                            taskQueue.notifyAll();
                        }
                    }
                };


//                long scheduledTime = System.currentTimeMillis() + unit.toMillis(initialDelay);
                MyScheduledTask task = new MyScheduledTask(handleDelayNonBlockingMain, scheduledTime, 3, period, unit);
//                MyScheduledTask task = new MyScheduledTask(command, scheduledTime, 3, period, unit);
                taskQueue.add(task);
                this.taskQueue.notifyAll();
            }
        }catch (Exception e){
            System.out.println("some thing wrong in scheduling task type 3");
            e.printStackTrace();
        }
    }

}
