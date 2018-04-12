package zero.storm.trident;

import org.apache.storm.trident.operation.BaseFilter;
import org.apache.storm.trident.operation.BaseFunction;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.operation.TridentOperationContext;
import org.apache.storm.trident.tuple.TridentTuple;

import java.util.Map;

/**
 * @author ningcheng
 * @date 2018/2/9
 */
public class Print extends BaseFilter {

    @Override
    public void prepare(Map conf, TridentOperationContext context) {
    }

    @Override
    public boolean isKeep(TridentTuple tuple) {
        System.out.println("ret:" + tuple.toString());
        return true;
    }
}
