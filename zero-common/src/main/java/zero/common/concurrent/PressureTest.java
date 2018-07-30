package zero.common.concurrent;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import zero.common.net.http.ConnectionManager;

import java.text.NumberFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ningcheng
 * @date 2017/10/31
 */
public class PressureTest extends Thread {

    private static AtomicInteger count = new AtomicInteger(0);
    private static NumberFormat nf = NumberFormat.getNumberInstance();

    static {
        nf.setMaximumFractionDigits(4);
    }

    private int threadNum;
    private int clientNum;
    private String url;
    private String postData;

    private float sumTime = 0;
    private float maxTime = 0;
    private long startTime = Long.MAX_VALUE;
    private long endTime = Long.MIN_VALUE;

    private PressureTest(int threadNum, int clientNum, String url, String postData) {
        this.threadNum = threadNum;
        this.clientNum = clientNum;
        this.url = url;
        this.postData = postData;
    }

    @Override
    public void run() {
        final PressureTest currentObj = this;
        final ConcurrentHashMap<Integer, ThreadRecord> records = new ConcurrentHashMap<Integer, ThreadRecord>();
        ExecutorService pool = new ThreadPoolExecutor(threadNum, threadNum,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024),
                new ThreadFactoryBuilder().setNameFormat("pressure-test-pool-%d").build(),
                new ThreadPoolExecutor.AbortPolicy());
        final CountDownLatch doneSignal = new CountDownLatch(clientNum);
        for (int i = 0; i < clientNum; i++) {
            pool.execute(() -> {
                int index = getIndex();
                long st = System.currentTimeMillis();
                try {
                    ConnectionManager.get(currentObj.url);
                } catch (Exception e) {
                    ///
                }
                records.put(index, new ThreadRecord(st, System.currentTimeMillis()));
                doneSignal.countDown();
            });
        }
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            ///
        }
        pool.shutdown();
        float recordTotalTime = 0;
        for (Map.Entry<Integer, ThreadRecord> i : records.entrySet()) {
            ThreadRecord record = i.getValue();
            recordTotalTime = ((float) (record.endTime - record.startTime)) / 1000;
            sumTime += recordTotalTime;
            if (recordTotalTime > maxTime) {
                maxTime = recordTotalTime;
            }
            if (record.startTime < startTime) {
                startTime = record.startTime;
            }
            if (record.endTime > endTime) {
                endTime = record.endTime;
            }
        }

        float avgTime = this.sumTime / records.size();
        float totalTime = ((float) (endTime - startTime)) / 1000;

        System.out.println("==========================================================================");
        System.out.println("Thread Num: " + threadNum + ", Client Count: " + clientNum);
        System.out.println("Avg Exec Time:   " + nf.format(avgTime) + " s");
        System.out.println("Max Exec Time:   " + nf.format(maxTime) + " s");
        System.out.println("Total Exec Time: " + nf.format(totalTime) + " s");
        System.out.println("Throughput:      " + nf.format(clientNum / totalTime) + " /s");
    }

    private static int getIndex() {
        return count.incrementAndGet();
    }

    public static void main(String[] args) {
//        go();
    }

    public static void go() {
        for (int j = 500; j <= 500; j += 100) {
            for (int i = 10; i <= 10; i += 10) {
                String url = "";
                new PressureTest(i, j, url, "").run();
            }
        }
        System.out.println("finished!");
    }

    class ThreadRecord {
        long startTime;
        long endTime;

        ThreadRecord(long startTime, long endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
