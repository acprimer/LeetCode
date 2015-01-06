/**
 * Created by yaodh on 2015/1/6.
 * <p/>
 * LeetCode: Maximum Product Subarray
 * Link: https://oj.leetcode.com/problems/maximum-product-subarray/
 * Description:
 * -----------------------------
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * -----------------------------
 * <p/>
 * Tag: Dynamic Programming
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] A) {
        int n = A.length;
        int ans = A[0];
        int[] maxp = new int[n];
        int[] minp = new int[n];
        maxp[0] = minp[0] = A[0];
        for (int i = 1; i < n; i++) {
            maxp[i] = Math.max(A[i], Math.max(maxp[i - 1] * A[i], minp[i - 1] * A[i]));
            minp[i] = Math.min(A[i], Math.min(maxp[i - 1] * A[i], minp[i - 1] * A[i]));
            ans = Math.max(ans, maxp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new MaximumProductSubarray().maxProduct(new int[]{2, -5, -2, -4, 3});
        System.out.println(ans);
    }
}
