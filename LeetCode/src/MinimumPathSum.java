/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Minimum Path Sum
 * Link: https://oj.leetcode.com/problems/minimum-path-sum/
 * Description:
 * -----------------------------
 * Given a m x n grid filled with non-negative numbers,
 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * -----------------------------
 * <p/>
 * Tag: Dynamic Programming
 */
public class MinimumPathSum {
    /*public int minPathSum(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) return 0;
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < column; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][column - 1];
    }*/

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length <= 0 || grid[0].length <= 0) return 0;
        int row = grid.length;
        int column = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (i == 0 && j == 0) continue;
                grid[i][j] += Math.min(cost(grid, i - 1, j), cost(grid, i, j - 1));
            }
        }
        return grid[row - 1][column - 1];
    }

    int cost(int[][] grid, int x, int y) {
        return (x < 0 || y < 0) ? 0x3f3f3f3f : grid[x][y];
    }

    public static void main(String[] args) {
        System.out.println(new MinimumPathSum().minPathSum(new int[][]{{1,3,1}, {1,5,1}, {4,2,1}}));
    }
}
