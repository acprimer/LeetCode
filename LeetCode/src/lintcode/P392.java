package lintcode;

public class P392 {
    public long houseRobber(int[] A) {
        int n = A.length;
        if (n == 0) return 0;
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i] = A[i];
            if (i - 1 >= 0) dp[i] = Math.max(dp[i], dp[i - 1]);
            if (i - 2 >= 0) dp[i] = Math.max(dp[i], A[i] + dp[i - 2]);
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(new P392().houseRobber(new int[]{5, 2, 1, 3}));
    }
}
