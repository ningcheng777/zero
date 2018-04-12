package zero.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;

import java.util.Arrays;
import java.util.List;

/**
 * @author ningcheng
 * @date 2018/4/4
 */
public class MySpark {

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("zeroSpark").setMaster("yarn");
        JavaSparkContext sc = new JavaSparkContext(conf);
        List<Integer> list = Arrays.asList(1, 2, 3);
        JavaRDD<Integer> javaRDD = sc.parallelize(list);
        JavaRDD<Integer> addOneRet = javaRDD.map((Function<Integer, Integer>) v1 -> v1 + 1);
        Integer sum = addOneRet.reduce((v1, v2) -> v1 + v2);
        System.out.println(sum);
        sc.stop();
    }
}
