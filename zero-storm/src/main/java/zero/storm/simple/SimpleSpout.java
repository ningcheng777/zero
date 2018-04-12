package zero.storm.simple;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichSpout;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.util.Map;

/**
 * @author ningcheng
 * @date 2018/1/26
 */
public class SimpleSpout implements IRichSpout {

    private SpoutOutputCollector collector;
    private int index = 0;

    @Override
    public void open(Map map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        collector = spoutOutputCollector;
    }

    @Override
    public void close() {

    }

    @Override
    public void activate() {

    }

    @Override
    public void deactivate() {

    }

    @Override
    public void nextTuple() {
        if (index++ < 5) {
            collector.emit(new Values(index), index);
        }
    }

    @Override
    public void ack(Object o) {
        System.out.println("ack");
    }

    @Override
    public void fail(Object o) {
        System.out.println("fail");
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("simple"));
    }

    @Override
    public Map<String, Object> getComponentConfiguration() {
        return null;
    }
}
