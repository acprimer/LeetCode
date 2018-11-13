import java.util.HashMap;
import java.util.Map;

public class PerfectSquares {
    // DP
//    public int numSquares(int n) {
//        int[] dp = new int[n + 1];
//        for (int i = 0; i <= n; i++) {
//            dp[i] = i;
//            for (int j = 0; j * j <= i; j++) {
//                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
//            }
//        }
//        return dp[n];
//    }

    public int numSquares(int n) {
        int root = (int) Math.sqrt(n);
        int[] pow = new int[root + 1];
        for (int i = 0; i <= root; i++) {
            pow[i] = i * i;
        }

        return dfs(pow, n, 0);
    }

    private Map<Integer, Integer> map = new HashMap<>();

    private int dfs(int[] pow, int n, int count) {
        if (n <= 1) return n;
        if (map.containsKey(n)) return map.get(n);
        int ans = n;
//        for (int i = 0; i < ; i++) {
//
//        }
        for (int i = n / pow[pow.length-1]; i >= 0; i--) {
            ans = Math.min(ans, i + dfs(pow, n - i * pow[pow.length-1], i));
        }
        map.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i+ " " + new PerfectSquares().numSquares(i));
//        }
//        System.out.println(new PerfectSquares().numSquares(12));
//        System.out.println(new PerfectSquares().numSquares(13));
//        System.out.println(new PerfectSquares().numSquares(43));
        System.out.println(new PerfectSquares().numSquares(211));
//        System.out.println(new PerfectSquares().numSquares(90));
//        System.out.println(new PerfectSquares().numSquares(2147483647));
    }
}
