/**
 * Created by yaodh on 2014/11/22.
 * <p/>
 * LeetCode: Word Search
 * Link: https://oj.leetcode.com/problems/word-search/
 * Description:
 * -----------------------------
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * For example,
 * Given board =
 * [
 *  ["ABCE"],
 *  ["SFCS"],
 *  ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * -----------------------------
 * <p/>
 * Tag: DFS
 */
public class WordSearch {
    boolean[][] vis;
    int row, column;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length <= 0) return false;
        row = board.length;
        column = board[0].length;
        vis = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 1)) return true;
                }
                vis[i][j] = false;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int idx) {
        if (idx >= word.length()) return true;
        vis[x][y] = true;
        final int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        for (int k = 0; k < directions.length; k++) {
            int tx = x + directions[k][0];
            int ty = y + directions[k][1];
            if (inBoard(tx, ty) && !vis[tx][ty] && board[tx][ty] == word.charAt(idx)) {
                vis[tx][ty] = true;
                if (dfs(board, word, tx, ty, idx + 1)) return true;
                vis[tx][ty] = false;
            }
        }
        return false;
    }

    private boolean inBoard(int tx, int ty) {
        if (tx < 0 || tx >= row || ty < 0 || ty >= column) return false;
        return true;
    }

    public static void main(String[] args) {
        boolean ans = new WordSearch().exist(
                new char[][]{{'a', 'b', 'c', 'e'},
                        {'s', 'f', 'c', 's'},
                        {'a', 'd', 'e', 'e'}},
                "abcb");
        System.out.println(ans);
    }
}
