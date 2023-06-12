package MCexamples.scheduleservice;


import java.util.Comparator;


class MyScheduledTaskComparator implements Comparator<MyScheduledTask> {

    // Overriding compare()method of Comparator
    // for descending order of cgpa
    public int compare(MyScheduledTask s1, MyScheduledTask s2) {
        if (s1.getScheduledTime() > s2.getScheduledTime())
            return 1;
        else if (s1.getScheduledTime() < s2.getScheduledTime())
            return -1;
        return 0;
    }
}