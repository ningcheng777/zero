package zero.zk;

import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;

/**
 * @author ningcheng
 * @date 2018/7/13
 */
public class Test {

    public static void main(String[] args) throws IOException {
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 60, event -> {

        });
    }
}
