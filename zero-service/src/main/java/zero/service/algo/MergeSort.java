package zero.service.algo;

/**
 * @author ningcheng
 * @date 2017/12/25
 */
public class MergeSort {

    private static int[] aux;

    public static void mergeSort(int[] s) {
        aux = new int[s.length];
        mergeSortInternal(s, 0, s.length - 1);
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
}
