package zero.service.algo;

/**
 * @author ningcheng
 * @date 2017/11/8
 */
public class SimpleSort {

    public static void bubbleSort(int[] s) {
        int endComparePosition = s.length - 1;
        int lastSwapPosition;
        while (endComparePosition > 0) {
            lastSwapPosition = 0;
            for (int i = 0; i < endComparePosition; i++) {
                if (SortUtil.compare(s[i], s[i + 1]) > 0) {
                    SortUtil.swap(s, i, i + 1);
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
                if (SortUtil.compare(s[i], minValue) < 0) {
                    minValue = s[i];
                    minPos = i;
                }
            }
            SortUtil.swap(s, startPos, minPos);
            startPos++;
        }
    }

    public static void insertSort(int[] s) {
        for (int insertPos = 1; insertPos < s.length; insertPos++) {
            for (int i = insertPos - 1; i >= 0; i--) {
                if (SortUtil.compare(s[i], s[insertPos]) <= 0) {
                    break;
                }
                SortUtil.swap(s, i + 1, i);
            }
        }
    }

}
