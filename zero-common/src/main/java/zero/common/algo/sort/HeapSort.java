package zero.common.algo.sort;

import zero.common.algo.Utils;

/**
 * @author ningcheng
 * @date 2017/12/25
 */
public class HeapSort {

    public static void sort(int[] s) {
        int len = s.length;//len是实际要排序的数据长度
        int[] pq = new int[len + 1];
        System.arraycopy(s, 0, pq, 1, len);
        for (int i = len / 2; i > 0; i--) {
            sink(pq, i, len);
        }
        while (len > 0) {
            Utils.swap(pq, 1, len--);
            sink(pq, 1, len);
        }
        System.arraycopy(pq, 1, s, 0, s.length);
    }

    private static void sink(int[] s, int k, int len) {//len是实际要排序的数据长度
        while (k * 2 <= len) {
            int i = k * 2;
            if (i < len && s[i + 1] >= s[i]) {
                i++;
            }
            if (s[k] >= s[i]) {
                break;
            }
            Utils.swap(s, k, i);
            k = i;
        }
    }

}
