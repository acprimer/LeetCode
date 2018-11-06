import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yaodh on 2018/11/5.
 */
public class ShortestBridge {
    private static final int[][] DIR = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int shortestBridge(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] visited = new int[row][col];
        int color = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] == 1 && visited[i][j] == 0) {
                    visited[i][j] = color;
                    dfs(A, visited, i, j, color);
                    color++;
                }
            }
        }
//        int ans = Integer.MAX_VALUE;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (A[i][j] == 1) {
//                    ans = Math.min(ans, bfs(A, visited, i, j));
//                }
//            }
//        }
        return bfs(A, visited);
    }

    private void dfs(int[][] A, int[][] vis, int x, int y, int color) {
        for (int i = 0; i < DIR.length; i++) {
            int dx = x + DIR[i][0];
            int dy = y + DIR[i][1];
            if (inBound(A, dx, dy) && A[dx][dy] == 1 && vis[dx][dy] != color) {
                vis[dx][dy] = color;
                dfs(A, vis, dx, dy, color);
            }
        }
    }

    private boolean inBound(int[][] A, int x, int y) {
        return x >= 0 && y >= 0 && x < A.length && y < A[0].length;
    }

    private class Pair {
        int x, y, d;

        Pair(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    // 单点使用BFS超时
    private int bfs(int[][] A, int[][] vis, int x, int y) {
        int color = vis[x][y];
        boolean[][] flag = new boolean[A.length][A[0].length];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int tx = pair.x;
            int ty = pair.y;
            int td = pair.d;
            flag[tx][ty] = true;
            for (int i = 0; i < DIR.length; i++) {
                int dx = tx + DIR[i][0];
                int dy = ty + DIR[i][1];
                if (inBound(A, dx, dy) && !flag[dx][dy] && vis[dx][dy] != color) {
                    if (vis[dx][dy] != 0 && vis[dx][dy] != color) {
                        return td;
                    }
                    queue.offer(new Pair(dx, dy, td + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    // 批量BFS
    private int bfs(int[][] A, int[][] color) {
        int n = A.length;
        int m = A[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (color[i][j] == 1) {
                    vis[i][j] = true;
                    queue.offer(new Pair(i,j,0));
                }
            }
        }
        while (!queue.isEmpty()) {
            int depth = queue.peek().d;
            while (!queue.isEmpty()) {
                Pair pair = queue.peek();
                if (pair.d == depth) {
                    queue.poll();
                    // 批量加入
                    for (int i = 0; i < DIR.length; i++) {
                        int dx = pair.x + DIR[i][0];
                        int dy = pair.y + DIR[i][1];
                        if (!inBound(A, dx, dy) || vis[dx][dy]) continue;
                        if (color[dx][dy] == 2) return pair.d;
                        vis[dx][dy] = true;
                        queue.offer(new Pair(dx, dy, pair.d + 1));
                    }
                } else break;
            }
        }
        return Integer.MAX_VALUE;
    }

    // 遍历可以通过
    private int shortestPath(int[][] A, int[][] vis, int x, int y) {
        int color = vis[x][y];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != 0 && vis[i][j] != color) {
                    ans = Math.min(ans, Math.abs(x-i) + Math.abs(y-j));
                }
            }
        }
        return ans - 1;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestBridge().shortestBridge(new int[][]{{0,1},{1,0}}));
        System.out.println(new ShortestBridge().shortestBridge(new int[][]{{0,1,0},{0,0,0},{0,0,1}}));
        System.out.println(new ShortestBridge().shortestBridge(new int[][]{{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}}));
        System.out.println(new ShortestBridge().shortestBridge(new int[][]{{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,1}}));
        long start = System.currentTimeMillis();
        System.out.println(new ShortestBridge().shortestBridge(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0}, {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1}, {1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0}, {1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}}));
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
