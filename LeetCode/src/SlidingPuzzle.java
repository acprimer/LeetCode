import java.util.*;

public class SlidingPuzzle {
    public static void main(String[] args) {
        System.out.println(new SlidingPuzzle().slidingPuzzle(
                new int[][] {
                        {3,2,4},
                        {1,5,0}
                }
        ));
    }

    public int slidingPuzzle(int[][] board) {
        int[] pos = find(board);
        return bfs(board, pos[0], pos[1]);
    }

    private int[] find(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    private int bfs(int[][] board, int x, int y) {
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Set<Integer> set = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(board, x, y, 0));
        while (!queue.isEmpty()) {
            Node p = queue.poll();
            if (p.done()) return p.step;
            if (set.contains(p.hash())) continue;
            set.add(p.hash());
            for (int[] d : dir) {
                int dx = p.x + d[0];
                int dy = p.y + d[1];
                if (inboard(p.board, dx, dy)) {
                    queue.offer(new Node(nextBoard(p.board, p.x, p.y, dx, dy), dx, dy, p.step + 1));
                }
            }
        }
        return -1;
    }

    private boolean inboard(int[][] board, int x, int y) {
        return x >= 0 && x < board.length
                && y >= 0 && y < board[0].length;
    }

    private int[][] nextBoard(int[][] board, int x, int y, int dx, int dy) {
        int[][] temp = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                temp[i][j] = board[i][j];
            }
        }
        temp[x][y] = board[dx][dy];
        temp[dx][dy] = board[x][y];
        return temp;
    }

    private class Node {
        int[][] board;
        int x, y;
        int step;

        public Node(int[][] board, int x, int y, int step) {
            this.board = board;
            this.x = x;
            this.y = y;
            this.step = step;
        }

        public int hash() {
            int hash = 0;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    hash = hash * 10 + board[i][j];
                }
            }
            return hash;
        }

        public boolean done() {
            return hash() == 123450;
        }

        @Override
        public String toString() {
            return hash() + " " + x + " " + y;
        }
    }
}
