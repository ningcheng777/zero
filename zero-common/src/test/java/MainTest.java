import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ningcheng
 * @date 2018/1/25
 */
public class MainTest {

    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(1);
        Runnable r = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(1);
        };
//        service.execute(r);
        new Thread(r).start();
        System.out.println(2);
    }

}
