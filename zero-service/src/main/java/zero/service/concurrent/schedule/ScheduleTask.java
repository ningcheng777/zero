package zero.service.concurrent.schedule;

import java.util.concurrent.*;

public class ScheduleTask {

    private static int count = 0;

    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(0);
        ScheduledFuture future = pool.scheduleAtFixedRate(
                () -> System.out.println(++count), 2, 1, TimeUnit.SECONDS);
        pool.schedule(() -> {
            System.out.println("stop");
            future.cancel(false);
        }, 10, TimeUnit.SECONDS);
    }
}