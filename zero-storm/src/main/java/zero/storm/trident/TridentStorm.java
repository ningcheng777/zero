package zero.storm.trident;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.trident.TridentTopology;
import org.apache.storm.trident.operation.BaseFunction;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.operation.builtin.Count;
import org.apache.storm.trident.testing.FixedBatchSpout;
import org.apache.storm.trident.testing.Split;
import org.apache.storm.trident.tuple.TridentTuple;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

/**
 * @author ningcheng
 * @date 2018/1/29
 */
public class TridentStorm {

    public static void main(String[] args) {

        TridentTopology topology = new TridentTopology();
        FixedBatchSpout spout = new FixedBatchSpout(new Fields("sentence"), 2,
                new Values("v1"),
                new Values("v2"),
                new Values("v3"),
                new Values("v4"));
//        spout.setCycle(true);

//        FeederBatchSpout spout = new FeederBatchSpout(ImmutableList.of("sentence"));

//        TridentState wordCounts =
        topology.newStream("spout1", spout)
                .each(new Fields("sentence"), new Split(), new Fields("word"))
                .groupBy(new Fields("word"))
                .aggregate(new Count(), new Fields("count"))
                .each(new Fields("count"), new Print(), new Fields("fin"));

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

    private static class Print extends BaseFunction {
        @Override
        public void execute(TridentTuple t, TridentCollector collector) {
            Long s = t.getLong(0);
            System.out.println("result:" + s);
            collector.emit(new Values("fin"));
        }
    }
}
