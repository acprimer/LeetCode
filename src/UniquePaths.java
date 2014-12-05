/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Unique Paths
 * Link: https://oj.leetcode.com/problems/unique-paths/
 * Description:
 * -----------------------------
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * -----------------------------
 * <p/>
 * Tag: Math DP
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) dp[i][0] = 1;
        for(int i=0;i<n;i++) dp[0][i] = 1;
        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
    /*public int uniquePaths(int m, int n) {
        m--;
        n--;
        // Calculate C(m+n, m)
        int sum = m + n, min = Math.min(m, n);
        long a = 1, b = 1;
        for (int i = 0; i < min; i++) {
            a *= (sum - i);
            b *= (min - i);
        }
        return (int) (a / b);
    }*/
    /*public int uniquePaths(int m, int n) {
        m--; n--;
        int[][] c = new int[m + n + 1][m + n + 1];
        for (int i = 0; i <= m + n; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
            }
        }
        return c[m + n][m];
    }*/

    public static void main(String[] args) {
        int ans = new UniquePaths().uniquePaths(10, 10);
        System.out.println(ans);
    }
}
