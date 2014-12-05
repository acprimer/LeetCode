/**
 * Created by yaodh on 2014/11/27.
 * <p/>
 * LeetCode: Reverse Integer
 * Link: https://oj.leetcode.com/problems/reverse-integer/
 * Description:
 * -----------------------------
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * -----------------------------
 * <p/>
 * Tag: Math
 */
public class ReverseInteger {
    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            // in case of overflow
            // we do not handle this case: Math.abs(ans) == Integer.MAX_VALUE / 10
            // because we can't get 2147483648 or 2147483649
            if (Math.abs(ans) > Integer.MAX_VALUE / 10) {
                return 0;
            }
            ans = ans * 10 + x % 10;
            x /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new ReverseInteger().reverse(-9);
        System.out.println(ans);
    }
}
