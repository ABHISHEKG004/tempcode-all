package MCexamples.scheduleservice;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;


@Getter
@Setter
public class MyScheduledTask {

    private final Runnable runnable;
    private Long scheduledTime;
    private final int taskType;
    private final Long period;
    private final TimeUnit unit;

    public MyScheduledTask(Runnable runnable, Long scheduledTime, int taskType, Long period, TimeUnit unit) {
        this.runnable = runnable;
        this.scheduledTime = scheduledTime;
        this.taskType = taskType;
        this.period = period;
        this.unit = unit;
    }
}