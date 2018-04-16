/**
 * Created by yaodh on 2018/4/16.
 */
public class LargestSumOfAverages {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[][] dp  = new double[K+1][n+1];
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + A[i-1];
            dp[1][i] = 1.0 * sum[i] / i;
        }
        for (int i = 2; i <= K; i++) {
            for (int j = i; j <= n; j++) {
                for (int k = i; k <= j; k++) {
                    double x = dp[i-1][k-1] + avg(sum, k, j);
                    dp[i][j] = Math.max(dp[i][j], x);
                }
            }
        }

        return dp[K][n];
    }

    private double avg(int[] sum, int start, int end) {
        return 1.0 * (sum[end] - sum[start - 1]) / (end - start + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LargestSumOfAverages().largestSumOfAverages(
                new int[]{3324,8299,5545,6172,5817}, 2));
    }
}