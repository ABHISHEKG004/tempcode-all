package JavaConcepts.Timer;

import java.util.TimerTask;
import java.util.Timer;

// Java program to demonstrate
//schedule method calls of JavaConcepts.Timer class

class Helper extends TimerTask
{
    private String name;

//    public int i = 0;
    public static int i = 0;

    public Helper(String name){
        this.name = name;
    }

    public void run()
    {
        System.out.println("JavaConcepts.Timer ran " + name + " -> " + (++i));
    }
}

public class TimerDemo
{
    public static void main(String[] args)
    {

        Timer timer = new Timer();
        TimerTask task1 = new Helper("helper1");
        TimerTask task2 = new Helper("helper2");
        TimerTask task3 = new Helper("helper3");

        timer.schedule(task1, 1000, 2000);

        timer.schedule(task1, 1500, 3000);

//        timer.schedule(task2, 2000, 3000);

//        timer.scheduleAtFixedRate(task3, 5000, 4000);

    }
}