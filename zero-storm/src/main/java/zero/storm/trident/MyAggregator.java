package zero.storm.trident;

import org.apache.storm.trident.operation.BaseAggregator;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.tuple.TridentTuple;

/**
 * @author ningcheng
 * @date 2018/2/9
 */
public class MyAggregator extends BaseAggregator<String> {

    @Override
    public String init(Object batchId, TridentCollector collector) {
        return null;
    }

    @Override
    public void aggregate(String val, TridentTuple tuple, TridentCollector collector) {

    }

    @Override
    public void complete(String val, TridentCollector collector) {
    }
}
