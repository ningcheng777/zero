import service.algo.Generator;
import service.algo.Sort;

/**
 * @author ningcheng
 * @date 2017/10/9
 */
public class MainTest {


    public static void main(String[] args) {

        int[] s = Generator.randomArray(1, 10, 5);
        Sort.bubbleSort(s);
        for (int i : s) {
            System.out.println(i);
        }

    }

}
