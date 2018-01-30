package zero.storm.simple;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

/**
 * @author ningcheng
 * @date 2018/1/26
 */
public class SimpleStorm {

    public static void main(String[] args) throws InterruptedException {
        Config config = new Config();
        config.setDebug(true);
        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("simple-spout", new SimpleSpout());
        builder.setBolt("simple-bolt-1", new SimpleBolt1()).shuffleGrouping("simple-spout");
        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("simple-storm", config, builder.createTopology());
        Thread.sleep(10000);
        cluster.shutdown();
    }
}
