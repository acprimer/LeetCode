/**
 * Created by yaodh on 2014/11/24.
 * <p/>
 * LeetCode: Maximum Subarray
 * Link: https://oj.leetcode.com/problems/maximum-subarray/
 * Description:
 * -----------------------------
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * -----------------------------
 * <p/>
 * Tag: DP
 */
public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        int[] dp = new int[A.length];
        dp[0] = A[0];
        int ans = dp[0];
        for (int i = 1; i < A.length; i++) {
            dp[i] = A[i];
            if (dp[i - 1] > 0) dp[i] += dp[i - 1];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
