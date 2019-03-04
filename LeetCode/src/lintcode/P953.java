package lintcode;

import java.util.ArrayList;
import java.util.List;

public class P953 {
    private int n;
    private List[] graph;
    private int[] degree;
    private int[] profit;

    public int getMaxScore(int[] x, int[] y, int[] cost, int[] profit) {
        n = profit.length;
        this.profit = profit;
        graph = new List[n];
        degree = new int[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList();
        }
        for (int i = 0; i < x.length; i++) {
            int u = x[i];
            graph[u].add(y[i]);
            graph[u].add(cost[i]);
            degree[u]++;
        }
        return dfs(0, profit[0]);
    }

    private int dfs(int u, int cur) {
        if (degree[u] == 0) return cur;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < graph[u].size(); i+=2) {
            int v = (int) graph[u].get(i);
            int e = (int) graph[u].get(i+1);
            max = Math.max(max, dfs(v, cur - e + profit[v]));
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new P953().getMaxScore(
                new int[]{0, 0, 0},
                new int[]{1, 2, 3},
                new int[]{1, 1, 1},
                new int[]{1, 1, 2, 3}
        ));
        System.out.println(new P953().getMaxScore(
                new int[]{0,1,2,3,3,3,1,7,1},
                new int[]{1,2,3,4,5,6,7,8,9},
                new int[]{47,48,44,95,84,61,51,86,43},
                new int[]{77,41,27,19,71,17,35,84,61,2}
        ));
    }
}
