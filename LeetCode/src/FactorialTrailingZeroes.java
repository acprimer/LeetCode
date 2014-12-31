/**
 * Created by yaodh on 2014/12/31.
 * <p/>
 * LeetCode: Factorial Trailing Zeroes
 * Link: https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 * Description:
 * -----------------------------
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * -----------------------------
 * <p/>
 * Tag: Math
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n != 0) {
            n /= 5;
            ans += n;
        }
        return ans;
    }
}
