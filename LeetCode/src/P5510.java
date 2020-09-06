public class P5510 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        if (!check(n, edges, 1) || !check(n, edges, 2)) return -1;
        return 0;
    }

    private boolean check(int n, int[][] edges, int type) {
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][0] != 3 && edges[i][i] != type) continue;

        }
        return false;
    }
}
