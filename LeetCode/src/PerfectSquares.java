import java.util.HashMap;
import java.util.Map;

public class PerfectSquares {
    public int numSquares(int n) {
        int root = (int) Math.sqrt(n);
        int[] pow = new int[root+1];
        for (int i = 0; i <= root; i++) {
            pow[i] = i * i;
        }

        return dfs(pow, n, root);
    }

    private Map<Integer, Integer> map = new HashMap<>();
    private int dfs(int[] pow, int n, int end) {
        if (end <= 1) return n;
        if (map.containsKey(n)) return map.get(n);
        int ans = n;
        for (int i = 0; i <= n / pow[end]; i++) {
            ans = Math.min(ans, i + dfs(pow, n - i * pow[end], end-1));
        }
        map.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i+ " " + new PerfectSquares().numSquares(i));
        }
        System.out.println(new PerfectSquares().numSquares(65535));
        System.out.println(new PerfectSquares().numSquares(2147483647));
    }
}
