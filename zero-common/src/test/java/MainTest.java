import java.math.BigDecimal;

/**
 * @author ningcheng
 * @date 2018/1/25
 */
public class MainTest {

    public static void main(String[] args) {
//        System.out.println(firstBadVersion(2126753390));
        System.out.println((int)1595065043);
    }

    public static int firstBadVersion(int n) {
        return bSearch(1, n);
    }

    private static int bSearch(int lo, int hi) {
        if (lo > hi) {
            return 0;
        }
        if (lo == hi) {
            return isBadVersion(lo) ? lo : 0;
        }
        int mid = mid(lo, hi);
        if (isFirstBadVersion(mid)) {
            return mid;
        }
        return isBadVersion(mid) ? bSearch(lo, mid) : bSearch(mid + 1, hi);
    }

    private static boolean isFirstBadVersion(int x) {
        if (x == 0) {
            return isBadVersion(0);
        }
        return isBadVersion(x) && isBadVersion(x - 1);
    }

    static boolean isBadVersion(int version) {
        return version >= 1702766719;
    }

    private static int mid(int a1, int a2) {
        return (int) (((long) a1 + a2) / 2);
    }
}
