package zero.storm.trident;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.trident.TridentTopology;
import org.apache.storm.trident.testing.FixedBatchSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.io.IOException;

/**
 * @author ningcheng
 * @date 2018/1/29
 */
public class TridentStorm {

    public static void main(String[] args) throws IOException, InterruptedException {

        TridentTopology topology = new TridentTopology();
        FixedBatchSpout spout = new FixedBatchSpout(new Fields("field"), 2,
                new Values(1),
                new Values(2),
                new Values(3),
                new Values(4),
                new Values(5)
        );
        topology.newStream("spout1", spout)
                .each(new Fields("field"), new Print());
        LocalCluster cluster = new LocalCluster();
        Config conf = new Config();
        conf.setDebug(true);
        cluster.submitTopology("tridentTopo", conf, topology.build());
//        Thread.sleep(10000);
//        cluster.shutdown();
    }

}
