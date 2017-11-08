package service.concurrent.task;

import java.util.concurrent.*;

public class ScheduleTask {

    private static int count = 0;

    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println(++count);
            }
        };

        ScheduledExecutorService schedule = Executors.newScheduledThreadPool(1);
        ScheduledFuture future = schedule.scheduleAtFixedRate(task, 2, 1, TimeUnit.SECONDS);
        schedule.schedule(new Runnable() {
            @Override
            public void run() {
                future.cancel(false);
            }
        }, 10, TimeUnit.SECONDS);
    }
}