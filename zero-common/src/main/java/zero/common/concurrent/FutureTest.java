package zero.common.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ningcheng
 * @date 2018/3/12
 */
public class FutureTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask futureTask = new FutureTask<String>(() -> "ss") {
            @Override
            protected void done() {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("future.done():" + get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService service = new ThreadPoolExecutor(
                1,
                3,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                (ThreadFactory) Thread::new);
        service.execute(futureTask);

        TimeUnit.SECONDS.sleep(2);
        System.out.println(futureTask.get());

    }
}
