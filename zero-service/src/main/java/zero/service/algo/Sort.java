package zero.service.algo;

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
                if (compare(s[i], s[i + 1]) > 0) {
                    swap(s, i, i + 1);
                    lastSwapPosition = i;
                }
            }
            endComparePosition = lastSwapPosition;
        }
    }

    public static void selectSort(int[] s) {
        int minValue;
        int minPos;
        int startPos = 0;
        while (startPos < s.length - 1) {
            minValue = s[startPos];
            minPos = startPos;
            for (int i = startPos + 1; i < s.length; i++) {
                if (compare(s[i], minValue) < 0) {
                    minValue = s[i];
                    minPos = i;
                }
            }
            swap(s, startPos, minPos);
            startPos++;
        }
    }

    public static void insertSort(int[] s) {
        for (int insertPos = 1; insertPos < s.length; insertPos++) {
            for (int i = insertPos - 1; i >= 0; i--) {
                if (compare(s[i], s[insertPos]) <= 0) {
                    break;
                }
                swap(s, i + 1, i);
            }
        }
    }

    private static void swap(int[] s, int p1, int p2) {
        int t = s[p1];
        s[p1] = s[p2];
        s[p2] = t;
    }

    private static int compare(int a, int b) {
        return a - b;
    }
}
