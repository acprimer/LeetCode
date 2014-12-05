/**
 * Created by yaodh on 2014/11/24.
 * <p/>
 * LeetCode: N-Queens II
 * Link: https://oj.leetcode.com/problems/n-queens-ii/
 * Description:
 * -----------------------------
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * -----------------------------
 * <p/>
 * Tag: Backtracking
 */
public class NQueensII {

    boolean[][] vis;

    public int totalNQueens(int n) {
        vis = new boolean[3][];
        vis[0] = new boolean[n];
        vis[1] = new boolean[2 * n];
        vis[2] = new boolean[2 * n];
        return dfs(0, n);
    }

    private int dfs(int row, int n) {
        if (row >= n) return 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[0][i] && !vis[1][row + i] && !vis[2][row - i + n - 1]) {
                vis[0][i] = vis[1][row + i] = vis[2][row - i + n - 1] = true;
                count += dfs(row + 1, n);
                vis[0][i] = vis[1][row + i] = vis[2][row - i + n - 1] = false;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int ans = new NQueensII().totalNQueens(8);
        System.out.println(ans);
    }
}
