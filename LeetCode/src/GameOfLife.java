import java.util.Arrays;

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length <= 0 || board[0].length <= 0) return;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neb = count(board, i, j);
                if (board[i][j] == 1) {
                    if (neb < 2 || neb > 3) {
                        // 活 --> 死
                        board[i][j] = -1;
                    }
                } else {
                    if (neb == 3) {
                        // 死 --> 活
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == -1) board[i][j] = 0;
                else if (board[i][j] == 2) board[i][j] = 1;
            }
        }
    }

    private int count(int[][] board, int x, int y) {
        final int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int cnt = 0;
        for (int i = 0; i < d.length; i++) {
            int tx = x + d[i][0];
            int ty = y + d[i][1];
            if (tx >= 0 && tx < board.length && ty >= 0 && ty < board[0].length) {
                if (board[tx][ty] == 1 || board[tx][ty] == -1) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        new GameOfLife().gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}
