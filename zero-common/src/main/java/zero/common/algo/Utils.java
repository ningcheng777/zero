package zero.common.algo;

import java.util.Random;

/**
 * @author ningcheng
 * @date 2017/12/25
 */
public class Utils {

    public static void swap(int[] s, int p1, int p2) {
        int t = s[p1];
        s[p1] = s[p2];
        s[p2] = t;
    }

    public static int[] genRandomArray(int min, int max, int n) {
        int len = max - min + 1;

        if (max < min || n > len) {
            return null;
        }

        //初始化给定范围的待选数组
        int[] source = new int[len];
        for (int i = min; i < min + len; i++) {
            source[i - min] = i;
        }

        int[] result = new int[n];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            //待选数组0到(len-1)随机一个下标
            index = Math.abs(rd.nextInt(len--));
            //将随机到的数放入结果集
            result[i] = source[index];
            //将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
            source[index] = source[len];
        }
        return result;
    }

}
