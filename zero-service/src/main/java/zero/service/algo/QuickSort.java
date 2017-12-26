package zero.service.algo;

/**
 * @author ningcheng
 * @date 2017/12/25
 */
public class QuickSort {

    public static void quickSort(int[] s) {
        quickSortInternal(s, 0, s.length - 1);
    }

    private static void quickSortInternal(int[] s, int left, int right) {
        if (left >= right) {
            return;
        }
        int midPosition = segment(s, left, right);
        quickSortInternal(s, 0, midPosition - 1);
        quickSortInternal(s, midPosition + 1, right);
    }

    private static int segment(int[] s, int left, int right) {
        int mid = s[left];
        int leftCursor = left + 1;
        int rightCursor = right;
        while (leftCursor <= rightCursor) {
            if (s[leftCursor] > mid) {
                SortUtil.swap(s, leftCursor, rightCursor--);
            } else if (s[rightCursor] < mid) {
                SortUtil.swap(s, leftCursor++, rightCursor);
            } else {
                leftCursor++;
                rightCursor--;
            }
        }
        SortUtil.swap(s, left, rightCursor);
        return rightCursor;
    }
}
