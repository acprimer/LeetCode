/**
 * Created by yaodh on 2015/4/9.
 * <p/>
 * LeetCode: Number of Islands
 * Link: https://leetcode.com/problems/number-of-islands/
 * Description:
 * -----------------------------
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * Example 1:
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * Example 2:
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 * -----------------------------
 * <p/>
 * Tag: DFS
 */
public class NumberOfIslands {
    public boolean isOK(int x, int y, int row, int col) {
        if (x >= 0 && x < row && y >= 0 && y < col) {
            return true;
        }
        return false;
    }

    public void dfs(char[][] grid, int x, int y) {
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        if (grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int tx = x + dir[i][0], ty = y + dir[i][1];
            if (isOK(tx, ty, grid.length, grid[0].length)) {
                dfs(grid, tx, ty);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    dfs(grid, i, j);
                }
            }
        }
        return island;
    }

    public static void main(String[] args) {
        String[] map = new String[]{"11000", "11000", "00100", "00011"};
        char[][] grid = new char[4][5];
        for (int i = 0; i < 4; i++) {
            grid[i] = map[i].toCharArray();
        }
        int ans = new NumberOfIslands().numIslands(grid);
        System.out.println(ans);
    }
}
