package lintcode;

import java.util.Arrays;

public class P1029 {
//    private int count;
//    private int src, dst;
//    private int limit;
//    int[][] graph;
//    private boolean[] vis;
//    private int ans;
//
    public static void main(String[] args) {
        System.out.println(new P1029().findCheapestPrice(18,
                new int[][]{{16,1,81},{15,13,47},{1,0,24},{5,10,21},{7,1,72},{0,4,88},{16,4,39},{9,3,25},{10,11,28},{13,8,93},{10,3,62},{14,0,38},{3,10,58},{3,12,46},{3,8,2},{10,16,27},{6,9,90},{14,8,6},{0,13,31},{6,4,65},{14,17,29},{13,17,64},{12,5,26},{12,1,9},{12,15,79},{16,11,79},{16,15,17},{4,0,21},{15,10,75},{3,17,23},{8,5,55},{9,4,19},{0,10,83},{3,7,17},{0,12,31},{11,5,34},{17,14,98},{11,14,85},{16,7,48},{12,6,86},{5,17,72},{4,12,5},{12,10,23},{3,2,31},{12,7,5},{6,13,30},{6,7,88},{2,17,88},{6,8,98},{0,7,69},{10,15,13},{16,14,24},{1,17,24},{13,9,82},{13,6,67},{15,11,72},{12,0,83},{1,4,37},{12,9,36},{9,17,81},{9,15,62},{8,15,71},{10,12,25},{7,6,23},{16,5,76},{7,17,4},{3,11,82},{2,11,71},{8,4,11},{14,10,51},{8,10,51},{4,1,57},{6,16,68},{3,9,100},{1,14,26},{10,7,14},{8,17,24},{1,11,10},{2,9,85},{9,6,49},{11,4,95}},
                        7, 2, 6));
    }
//
//    // DFS 解法
//    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//        this.count = n;
//        this.src = src;
//        this.dst = dst;
//        this.limit = K;
//        vis = new boolean[n];
//        Arrays.fill(vis, false);
//        ans = Integer.MAX_VALUE;
//        graph = new int[n][n];
//        for (int[] e : flights) {
//            graph[e[0]][e[1]] = e[2];
//        }
//        vis[src] = true;
//        dfs(src, 0, 0);
//        if (ans == Integer.MAX_VALUE) return -1;
//        return ans;
//    }
//
//    private void dfs(int u, int cost, int depth) {
//        if (depth > limit || cost >= ans) return;
//        for (int v = 0; v < count; v++) {
//            if (!vis[v] && graph[u][v] > 0) {
//                if (v == dst) ans = Math.min(ans, cost + graph[u][v]);
//                else {
//                    vis[v] = true;
//                    dfs(v, cost + graph[u][v], depth + 1);
//                    vis[v] = false;
//                }
//            }
//        }
//    }

    // Dijstra 解法
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        for (int[] e : graph) {
            Arrays.fill(e, 0x3f3f3f);
        }
        for (int[] e : flights) {
            graph[e[0]][e[1]] = e[2];
        }
        int[] d = new int[n];
        int[] trans = new int[n];
        Arrays.fill(trans, 0);
        boolean[] vis = new boolean[n];
        Arrays.fill(d, 0x3f3f3f);
        for (int i = 0; i < n; i++) {
            d[i] = graph[src][i];
        }
        vis[src] = true;
        int ans = d[dst];
        for (int i = 0; i < n; i++) {
            int min = 0x3f3f3f;
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && d[j] < min) {
                    min = d[u =j];
                }
            }
            if (u == -1 || u == dst) break;
            vis[u] = true;
            for (int j = 0; j < n; j++) {
                if (!vis[j] && d[u] + graph[u][j] < d[j]) {
                    d[j] = d[u] + graph[u][j];
                    trans[j] = trans[u] + 1;
                    if (j == dst && trans[j] <= K && d[j] < ans) {
                        ans = d[j];
                    }
                }
            }
        }
        return ans == 0x3f3f3f ? -1 : ans;
    }
}
