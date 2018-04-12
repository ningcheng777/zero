package zero.storm.simple;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ningcheng
 * @date 2018/1/26
 */
public class SimpleBolt1 implements IRichBolt {

    private OutputCollector collector;
    private List<Integer> values = new ArrayList<>();

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        collector = outputCollector;
    }

    @Override
    public void execute(Tuple tuple) {
        Integer val = tuple.getInteger(0);
        if (val == 3) {
            collector.fail(tuple);
            return;
        }
        values.add(val);
        collector.emit(tuple, new Values(val));
//        collector.ack(tuple);
    }

    @Override
    public void cleanup() {
        System.out.println("myResult1:");
        values.forEach(System.out::println);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("simple1"));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
