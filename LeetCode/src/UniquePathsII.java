/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Unique Paths II
 * Link: https://oj.leetcode.com/problems/unique-paths-ii/
 * Description:
 * -----------------------------
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 * -----------------------------
 * <p/>
 * Tag: DP
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length <= 0 || obstacleGrid[0].length <= 0) {
            return 0;
        }
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] dp = new int[row][column];
        dp[0][0] = (obstacleGrid[0][0] == 0 ? 1 : 0);
        for (int i = 1; i < row; i++) {
            if (obstacleGrid[i][0] == 0) dp[i][0] = dp[i - 1][0];
        }
        for (int i = 1; i < column; i++) {
            if (obstacleGrid[0][i] == 0) dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][column - 1];
    }

    public static void main(String[] args) {
        int ans = new UniquePathsII().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        System.out.println(ans);
    }
}
