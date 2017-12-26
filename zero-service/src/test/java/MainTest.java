import zero.service.algo.Generator;
import zero.service.algo.HeapSort;

/**
 * @author ningcheng
 * @date 2017/10/9
 */
public class MainTest {

    public static void main(String[] args) throws Exception {
        int[] s = Generator.randomArray(1, 20, 10);
        HeapSort.sort(s);
        for (int i : s) {
            System.out.println(i);
        }
    }

}
