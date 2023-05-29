package JavaConcepts.Timer;

// Java program to demonstrate
// scheduleAtFixedRate method of JavaConcepts.Timer class

import java.util.Timer;
import java.util.TimerTask;
import java.util.*;


class Helper2 extends TimerTask
{
    public static int i = 0;
    public void run()
    {
        System.out.println("JavaConcepts.Timer ran " + ++i);
        if(i == 4)
        {
            synchronized(TimerDemo2.obj)
            {
                TimerDemo2.obj.notify();
            }
        }
    }

}


public class TimerDemo2
{
    protected static TimerDemo2 obj;
    public static void main(String[] args) throws InterruptedException
    {
        obj = new TimerDemo2();

        //creating a new instance of timer class
        Timer timer = new Timer();
        TimerTask task = new Helper2();

        //instance of date object for fixed-rate execution
        Date date = new Date();

        timer.scheduleAtFixedRate(task, date, 5000);

        System.out.println("JavaConcepts.Timer running");
        synchronized(obj)
        {
            //make the main thread wait
            obj.wait();

            //once timer has scheduled the task 4 times,
            //main thread resumes
            //and terminates the timer
            timer.cancel();

            //purge is used to remove all cancelled
            //tasks from the timer'stack queue
            System.out.println(timer.purge());
        }
    }
}