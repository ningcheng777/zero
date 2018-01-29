package zero.storm.simple;

import org.apache.storm.task.OutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Tuple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ningcheng
 * @date 2018/1/26
 */
public class SimpleBolt1 implements IRichBolt {

    private OutputCollector collector;
    private List<String> values = new ArrayList<>();

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector outputCollector) {
        collector = outputCollector;
    }

    @Override
    public void execute(Tuple tuple) {
        String val = tuple.getString(0);
        if (!values.contains(val)) {
            values.add(val);
            collector.fail(tuple);
        }
        values.add(val + ",2");
        collector.ack(tuple);
    }

    @Override
    public void cleanup() {
        values.forEach(System.out::println);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
