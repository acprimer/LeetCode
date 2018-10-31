/**
 * Created by yaodh on 2018/10/18.
 */
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        int ans = maxSum(A, 1);
        if (ans < 0) return ans;
        return Math.max(ans, sum(A) + maxSum(A, -1));
    }

    private int sum(int[] A) {
        int sum = 0;
        for (int n : A) sum += n;
        return sum;
    }

    private int maxSum(int[] A, int flag) {
        int[] dp = new int[A.length];
        dp[0] = A[0] * flag;
        int ans = dp[0];
        for (int i = 1; i < A.length; i++) {
            if (dp[i-1] > 0) dp[i] = dp[i-1] + A[i] * flag;
            else dp[i] = A[i] * flag;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{1,-2,3,-2}));
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{5, -3, 5}));
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{3, -1, 2, -1}));
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{3, -2, 2, -3}));
        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{-2, -3, -1}));
    }
}
