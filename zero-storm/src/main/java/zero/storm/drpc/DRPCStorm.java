package zero.storm.drpc;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.LocalDRPC;
import org.apache.storm.drpc.LinearDRPCTopologyBuilder;

/**
 * @author ningcheng
 * @date 2018/1/26
 */
public class DRPCStorm {

    public static void main(String[] args) {
        LocalDRPC drpc = new LocalDRPC();
        LinearDRPCTopologyBuilder builder = new LinearDRPCTopologyBuilder("test");
        builder.addBolt(new DRPCBolt(), 3);
        LocalCluster cluster = new LocalCluster();
        Config conf = new Config();
        conf.setDebug(true);
        cluster.submitTopology("drpc-storm", conf, builder.createLocalTopology(drpc));
        System.out.println(drpc.execute("test", "hello"));
        cluster.shutdown();
        drpc.shutdown();
    }
}
