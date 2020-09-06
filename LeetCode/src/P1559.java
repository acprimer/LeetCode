public class P1559 {
    public static void main(String[] args) {
        System.out.println(new P1559().containsCycle(new char[][]{{'a','a','a','a'},{'a','b','b','a'},{'a','b','b','a'},{'a','a','a','a'}}));
        System.out.println(new P1559().containsCycle(new char[][]{{'c','c','c','a'},{'c','d','c','c'},{'c','c','e','c'},{'f','c','c','c'}}));
        System.out.println(new P1559().containsCycle(new char[][]{{'a','b','b'},{'b','z','b'},{'b','b','a'}}));
        System.out.println(new P1559().containsCycle(new char[][]{{'a'},{'a'}}));
    }

    private boolean[][] visited;
    int n = 0, m = 0;
    public boolean containsCycle(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int[][] f = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    f[i][j] = 1;
                    if (check(grid, f, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean check(char[][] grid, int[][] f, int x, int y, int lastX, int lastY) {
        visited[x][y] = true;
        int[][] dir = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        for (int i = 0; i < dir.length; i++) {
            int dx = x + dir[i][0];
            int dy = y + dir[i][1];
            if (dx == lastX && dy == lastY) continue;
            if (inBoard(dx, dy) && grid[dx][dy] == grid[x][y]) {
                if (f[dx][dy] == 1) {
                    return true;
                }
                f[dx][dy] = 1;
                if (check(grid, f, dx, dy, x, y)) {
                    return true;
                }
                f[dx][dy] = 0;
            }
        }
        return false;
    }

    private boolean inBoard(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
