package zero.storm.trident;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.trident.TridentTopology;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.io.IOException;

/**
 * @author ningcheng
 * @date 2018/1/29
 */
public class TridentStorm {

    public static void main(String[] args) throws IOException {

        TridentTopology topology = new TridentTopology();
        MySpout spout = new MySpout(new Fields("location"), 2,
                new Values("v1"),
                new Values("v2"),
                new Values("v3"),
                new Values("v4"),
                new Values("v5"),
                new Values("v6"),
                new Values("v7")
        );

//        FeederBatchSpout spout = new FeederBatchSpout(ImmutableList.of("sentence"));

//        TridentState wordCounts =
        topology.newStream("spout1", spout)
//                .parallelismHint(4)
//                .each(new Fields("sentence"), new Print())
//                .partitionAggregate(new Fields("sentence"), new Count(), new Fields("count"))
//                .parallelismHint(2)
//                .shuffle()
                .each(new Fields("location"), new Print())
                .parallelismHint(2);
//                .groupBy(new Fields("word"))

//                .each(new Fields("count"), new Print(), new Fields("fin"));

//        LocalDRPC drpc = new LocalDRPC();
//        topology.newDRPCStream("words")
//                .each(new Fields("args"), new Split(), new Fields("word"))
//                .groupBy(new Fields("word"))
//                .stateQuery(wordCounts, new Fields("word"), new MapGet(), new Fields("count"))
//                .each(new Fields("count"), new FilterNull())
//                .aggregate(new Fields("count"), new Sum(), new Fields("sum"))
//

        LocalCluster cluster = new LocalCluster();
        Config conf = new Config();
        conf.setMaxTaskParallelism(10);
//        conf.setDebug(true);
        cluster.submitTopology("wordCounter", conf, topology.build());
//        spout.feed(ImmutableList.of(new Values("apples")));
//        System.out.println("drpc result" + drpc.execute("words", "apples"));

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            ///
//        }
//        cluster.shutdown();
//        drpc.shutdown();
    }

}
