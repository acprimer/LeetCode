/**
 * Created by yaodh on 2018/11/6.
 */
public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = A[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                if (j + 1 < m)
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1]);
                dp[i][j] += A[i][j];
            }
        }
        int ans = dp[n - 1][0];
        for (int i = 1; i < m; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumFallingPathSum().minFallingPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, -100}}));
    }
}
