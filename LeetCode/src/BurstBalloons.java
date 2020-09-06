public class BurstBalloons {

    public static void main(String[] args) {
        System.out.println(new BurstBalloons().maxCoins(new int[]{3,1,5,8}));
    }

    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 1;
        }

        int len = nums.length;
        int[] fake = new int[len + 2];
        fake[0] = fake[len + 1] = 1;
        for (int i = 1; i <= len; i++) {
            fake[i] = nums[i-1];
        }
        int[][] dp = new int[len+2][len+2];
        for (int i = 1; i <= len; i++) {
            dp[1][i] = fake[i-1] * fake[i] * fake[i+1];
        }
        for (int L = 2; L <= len; L++) {
            for (int i = L; i <= len; i++) {
                int start = i-L+1;
                int end = i;
                for (int j = start; j <= end; j++) {
                    int coins = dp[j-start][j-1] + dp[end-j][end] + fake[j] * fake[start-1] * fake[end+1];
                    dp[L][i] = Math.max(dp[L][i], coins);
                }
            }
        }

        return dp[len][len];
    }
}
