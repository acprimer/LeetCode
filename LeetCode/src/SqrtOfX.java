/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Sqrt(x)
 * Link: https://oj.leetcode.com/problems/sqrtx/
 * Description:
 * -----------------------------
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * -----------------------------
 * <p/>
 * Tag: Binary Search
 */
public class SqrtOfX {
    public int sqrt(int x) {
        if (x <= 1) return x;
        // right = x; will be wrong.
        int left = 1, right = x / 2;
        while (left <= right) {
            int mid = (left + right) >> 1;
            long product = (long) mid * (long) mid;
            if (product == x) return mid;
            else if (product > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
        int ans = new SqrtOfX().sqrt(3);
        System.out.println(ans);
    }
}
