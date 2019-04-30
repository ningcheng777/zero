import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ningcheng
 * @date 2018/1/25
 */
public class MainTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = Lists.newArrayList(1);
        Map<Integer, List<Integer>> collect = list.stream().collect(Collectors.groupingBy(i -> i));
    }
}
