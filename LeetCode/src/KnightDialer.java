/**
 * Created by yaodh on 2018/11/5.
 */
public class KnightDialer {
    private static final int MOD = 1000000007;

    public int knightDialer(int N) {
        int[][] d = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {3, 9, 0}, {}, {1, 7, 0}, {2, 6}, {1, 3}, {2, 4}};
        int[][] dp = new int[N][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < d[j].length; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][d[j][k]]) % MOD;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[N - 1][i]) % MOD;
        }
        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(new KnightDialer().knightDialer(1));
//        System.out.println(new KnightDialer().knightDialer(2));
        System.out.println(new KnightDialer().knightDialer(161));
    }
}
