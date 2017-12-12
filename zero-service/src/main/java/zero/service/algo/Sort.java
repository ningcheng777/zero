package zero.service.algo;

/**
 * @author ningcheng
 * @date 2017/11/8
 */
public class Sort {

    private static int[] aux;

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

    public static void mergeSort(int[] s) {
        aux = new int[s.length];
        mergeSortInternal(s, 0, s.length - 1);
    }

    public static void quickSort(int[] s) {
        quickSortInternal(s, 0, s.length - 1);
    }

    private static void mergeSortInternal(int[] s, int left, int right) {
        if (right <= left) {
            return;
        }
        int mid = (right + left) / 2;
        mergeSortInternal(s, left, mid);
        mergeSortInternal(s, mid + 1, right);
        merge(s, left, right, mid);
    }

    private static void merge(int[] s, int left, int right, int mid) {
        System.arraycopy(s, left, aux, left, right + 1 - left);
        int leftCursor = left;
        int rightCursor = mid + 1;
        for (int j = left; j <= right; j++) {
            if (leftCursor > mid) {
                s[j] = aux[rightCursor++];
            } else if (rightCursor > right) {
                s[j] = aux[leftCursor++];
            } else if (aux[leftCursor] > aux[rightCursor]) {
                s[j] = aux[rightCursor++];
            } else {
                s[j] = aux[leftCursor++];
            }
        }
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
                swap(s, leftCursor, rightCursor--);
            } else if (s[rightCursor] < mid) {
                swap(s, leftCursor++, rightCursor);
            } else {
                leftCursor++;
                rightCursor--;
            }
        }
        swap(s, left, rightCursor);
        return rightCursor;
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
