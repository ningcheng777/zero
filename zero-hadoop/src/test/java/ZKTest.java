import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryNTimes;

import java.util.concurrent.TimeUnit;

/**
 * @author ningcheng
 * @date 2018/2/2
 */
public class ZKTest {

    public static void main(String[] args) throws Exception {
        CuratorFramework client = CuratorFrameworkFactory.newClient(
                "127.0.0.1",
                new RetryNTimes(10, 5000)
        );
        client.start();

//        client.create()
//                .creatingParentsIfNeeded()
//                .forPath("/zero/test", "asd".getBytes());

//        List<String> ls = client.getChildren()
//                .forPath("/zero");
//        System.out.println(JSONObject.toJSONString(ls));

//        byte[] data = client.getData()
//                .forPath("/zero/test");
//        System.out.println(new String(data));

//        client.setData()
//                .forPath("/zero/test", "gg".getBytes());

        Thread t1 = new Thread(() -> {
            doWithLock(client);
        }, "t1");
        Thread t2 = new Thread(() -> {
            doWithLock(client);
        }, "t2");

        t1.start();
        t2.start();

    }

    private static void doWithLock(CuratorFramework client) {
        InterProcessMutex lock = new InterProcessMutex(client, "/zero/lock");
        try {
            if (lock.acquire(10 * 1000, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + " hold lock");
                Thread.sleep(5000L);
                System.out.println(Thread.currentThread().getName() + " release lock");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                lock.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
