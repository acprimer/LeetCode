package lintcode;

import java.util.Arrays;

public class P1029 {
    private int count;
    private int src, dst;
    private int limit;
    int[][] graph;
    private boolean[] vis;
    private int ans;

    public static void main(String[] args) {
        System.out.println(new P1029().findCheapestPrice(3,
                new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        this.count = n;
        this.src = src;
        this.dst = dst;
        this.limit = K;
        vis = new boolean[n];
        Arrays.fill(vis, false);
        ans = Integer.MAX_VALUE;
        graph = new int[n][n];
        for (int[] e : flights) {
            graph[e[0]][e[1]] = e[2];
        }
        vis[src] = true;
        dfs(src, 0, 0);
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }

    private void dfs(int u, int cost, int depth) {
        if (depth > limit || cost >= ans) return;
        for (int v = 0; v < count; v++) {
            if (!vis[v] && graph[u][v] > 0) {
                if (v == dst) ans = Math.min(ans, cost + graph[u][v]);
                else {
                    vis[v] = true;
                    dfs(v, cost + graph[u][v], depth + 1);
                    vis[v] = false;
                }
            }
        }
    }
}
