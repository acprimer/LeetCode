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
 * Tag: DP Divide and Conquer
 */
public class MaximumSubarray {

    public int maxSubArray(int[] A) {
        return bSearch(A, 0, A.length - 1);
    }

    // divide and conquer
    private int bSearch(int[] a, int start, int end) {
        if (start == end) {
            return a[start];
        }
        int mid = (start + end) >> 1;
        int leftMax = bSearch(a, start, mid);
        int rightMax = bSearch(a, mid + 1, end);
        int sum = a[mid], leftSum = a[mid], rightSum = a[mid+1];
        for (int i = mid-1; i >= start; i--) {
            sum += a[i];
            leftSum = Math.max(leftSum, sum);
        }
        sum = a[mid+1];
        for (int i = mid + 2; i <= end; i++) {
            sum += a[i];
            rightSum = Math.max(rightSum, sum);
        }
        return Math.max(Math.max(leftMax, rightMax), leftSum + rightSum);
    }
    // DP
    /*public int maxSubArray(int[] A) {
        int[] dp = new int[A.length];
        dp[0] = A[0];
        int ans = dp[0];
        for (int i = 1; i < A.length; i++) {
            dp[i] = A[i];
            if (dp[i - 1] > 0) dp[i] += dp[i - 1];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }*/

    public static void main(String[] args) {
        int ans = new MaximumSubarray().maxSubArray(new int[]{-2, -1});
        System.out.println(ans);
    }
}
