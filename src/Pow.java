/**
 * Created by yaodh on 2014/11/24.
 * <p/>
 * LeetCode: Pow(x, n)
 * Link: https://oj.leetcode.com/problems/powx-n/
 * Description:
 * -----------------------------
 * Implement pow(x, n).
 * -----------------------------
 * <p/>
 * Tag: Bit
 */
public class Pow {
    public double pow(double x, int n) {
        boolean flag = false;
        if (n < 0) {
            flag = true;
            n = -n;
        }
        double[] powers = new double[32];
        powers[0] = x;
        for (int i = 1; i < 32 && (1 << i) <= n; i++) {
            powers[i] = powers[i - 1] * powers[i - 1];
        }
        int bitIndex = 0;
        double ans = 1.0;
        while (n > 0) {
            if (n % 2 == 1) ans *= powers[bitIndex];
            n /= 2;
            bitIndex++;
        }
        if (flag) ans = 1.0 / ans;
        return ans;
    }

    public static void main(String[] args) {
        double ans = new Pow().pow(2.0, -2);
        System.out.println(ans);
    }
}
