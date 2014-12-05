/**
 * Created by yaodh on 2014/11/27.
 * <p/>
 * LeetCode: Sudoku Solver
 * Link: https://oj.leetcode.com/problems/sudoku-solver/
 * Description:
 * -----------------------------
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * -----------------------------
 * <p/>
 * Tag: Backtracking
 */
public class SudokuSolver {
    boolean[][][] vis = new boolean[3][9][9];

    public void solveSudoku(char[][] board) {
        isValidSudoku(board);
        dfs(board, 0, 0);
    }

    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) return false;
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

    private boolean dfs(char[][] board, int x, int y) {
        if (x >= 9) {
            return true;
        }
        int tx = x, ty = y + 1;
        if (ty >= 9) {
            ty = 0;
            tx++;
        }
        if (board[x][y] != '.') {
            return dfs(board, tx, ty);
        }
        for (int num = 0; num < 9; num++) {
            if (vis[0][x][num] || vis[1][y][num] || vis[2][(x / 3) * 3 + y / 3][num]) {
                continue;
            }
            board[x][y] = (char) (num + 1 + '0');
            vis[0][x][num] = vis[1][y][num] = vis[2][(x / 3) * 3 + y / 3][num] = true;
            if (dfs(board, tx, ty)) return true;
            vis[0][x][num] = vis[1][y][num] = vis[2][(x / 3) * 3 + y / 3][num] = false;
            board[x][y] = '.';
        }
        return false;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"..9748...", "7........", ".2.1.9...", "..7...24.", ".64.1.59.", ".98...3..", "...8.3.2.", "........6", "...2759.."};
        char[][] board = new char[9][9];
        for (int i = 0; i < 9; i++) {
            board[i] = str[i].toCharArray();
        }
        new SudokuSolver().solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
