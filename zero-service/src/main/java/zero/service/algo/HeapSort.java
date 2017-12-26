package zero.service.algo;

/**
 * @author ningcheng
 * @date 2017/12/25
 */
public class HeapSort {

    public static void sort(int[] s) {
        int len = s.length;
        int[] pq = new int[len + 1];
        System.arraycopy(s, 0, pq, 1, len);
        for (int i = len / 2; i > 0; i--) {
            sink(pq, i, len);
        }
        while (len > 0) {
            SortUtil.swap(pq, 1, len--);
            sink(pq, 1, len);
        }
        System.arraycopy(pq, 1, s, 0, s.length);
    }

    private static void sink(int[] s, int k, int l) {
        while (k * 2 <= l) {
            int i = k * 2;
            if (i < l && s[i + 1] >= s[i]) {
                i++;
            }
            if (s[k] >= s[i]) {
                break;
            }
            SortUtil.swap(s, k, i);
            k = i;
        }
    }

}
