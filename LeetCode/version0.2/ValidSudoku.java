/**
 * Created by yaodh on 2014/11/27.
 * <p/>
 * LeetCode: Valid Sudoku
 * Link: https://oj.leetcode.com/problems/valid-sudoku/
 * Description:
 * -----------------------------
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A partially filled sudoku which is valid.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable.
 * Only the filled cells need to be validated.
 * -----------------------------
 * <p/>
 * Tag: Hash
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) return false;
        boolean[][][] vis = new boolean[3][9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0' - 1;
                if (vis[0][i][num] || vis[1][j][num] || vis[2][(i / 3) * 3 + j / 3][num]) {
                    return false;
                }
                vis[0][i][num] = vis[1][j][num] = vis[2][(i / 3) * 3 + j / 3][num] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"..4...63.",".........","5......9.",
                "...56....","4.3.....1","...7.....",
                "...5.....",".........","........."};
        char[][] board = new char[9][9];
        for(int i=0;i<9;i++) {
            board[i] = str[i].toCharArray();
        }
        boolean ans = new ValidSudoku().isValidSudoku(board);
        System.out.println(ans);
    }
}
