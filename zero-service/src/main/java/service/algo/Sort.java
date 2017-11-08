package service.algo;

/**
 * @author ningcheng
 * @date 2017/11/8
 */
public class Sort {

    public static void bubbleSort(int[] s) {
        int endComparePosition = s.length - 1;
        int lastSwapPosition;
        while (endComparePosition > 0) {
            lastSwapPosition = 0;
            for (int i = 0; i < endComparePosition; i++) {
                if (s[i] > s[i + 1]) {
                    swap(s, i, i + 1);
                    lastSwapPosition = i;
                }
            }
            endComparePosition = lastSwapPosition;
        }
    }

    private static void swap(int[] s, int p1, int p2) {
        int t = s[p1];
        s[p1] = s[p2];
        s[p2] = t;
    }
}
