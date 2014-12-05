import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/24.
 * <p/>
 * LeetCode: N-Queens
 * Link: https://oj.leetcode.com/problems/n-queens/
 * Description:
 * -----------------------------
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement,
 * where 'Q' and '.' both indicate a queen and an empty space respectively.
 * -----------------------------
 * <p/>
 * Tag: Backtracking
 */
public class NQueens {
    List<String[]> ans;
    boolean[][] vis;

    public List<String[]> solveNQueens(int n) {
        ans = new ArrayList<String[]>();
        vis = new boolean[3][];
        vis[0] = new boolean[n];
        vis[1] = new boolean[2 * n];
        vis[2] = new boolean[2 * n];
        List<Integer> puzzle = new ArrayList<Integer>();
        dfs(0, n, puzzle);
        return ans;
    }

    private void dfs(int row, int n, List<Integer> puzzle) {
        if (row >= n) {
            char[][] board = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    board[i][j] = '.';
                }
            }
            for (int i = 0; i < puzzle.size() - 1; i += 2) {
                int x = puzzle.get(i);
                int y = puzzle.get(i + 1);
                board[x][y] = 'Q';
            }
            String[] queen = new String[n];
            for (int i = 0; i < n; i++) {
                queen[i] = new String(board[i]);
            }
            ans.add(queen);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!vis[0][i] && !vis[1][row + i] && !vis[2][row - i + n - 1]) {
                vis[0][i] = vis[1][row + i] = vis[2][row - i + n - 1] = true;
                List<Integer> newPuzzle = new ArrayList<Integer>(puzzle);
                newPuzzle.add(row);
                newPuzzle.add(i);
                dfs(row + 1, n, newPuzzle);
                vis[0][i] = vis[1][row + i] = vis[2][row - i + n - 1] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<String[]> ans = new NQueens().solveNQueens(8);
        for (String[] board : ans) {
            for (int i = 0; i < board.length; i++) {
                System.out.println(board[i]);
            }
            System.out.println();
        }
    }
}
