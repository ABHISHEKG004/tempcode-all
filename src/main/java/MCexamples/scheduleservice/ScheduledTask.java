package MCexamples.scheduleservice;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.TimeUnit;

@Getter
@Setter
public class ScheduledTask {

    private final Runnable runnable;
    private Long scheduledTime;
    private final int taskType;
    private final Long period;
    private final Long delay;
    private final TimeUnit unit;

    public ScheduledTask(Runnable runnable, Long scheduledTime, int taskType, Long period, Long delay, TimeUnit unit) {
        this.runnable = runnable;
        this.scheduledTime = scheduledTime;
        this.taskType = taskType;
        this.period = period;
        this.delay = delay;
        this.unit = unit;
    }
}
