public class P1563 {
    public static void main(String[] args) {
        System.out.println(new P1563().stoneGameV(new int[] {4}));
    }

    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        int[] sum = new int[n];
        sum[0] = stoneValue[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1] + stoneValue[i];
        }
        int[][] dp = new int[n][n];
        for (int layer = 1; layer < n; layer++) {
            for (int i = layer; i < n; i++) {
                int j = i - layer;
                for (int k = j; k < i; k++) {
                    int cal = 0;
                    int leftSum = sum[k] - (j > 0 ? sum[j-1] : 0);
                    int rightSum = sum[i] - sum[k];
                    if (leftSum < rightSum) {
                        cal = leftSum + dp[k-j][k];
                    } else if (leftSum > rightSum) {
                        cal = rightSum + dp[i-k-1][i];
                    } else {
                        cal = Math.max(leftSum + dp[k-j][k], rightSum + dp[i-k-1][i]);
                    }
                    dp[layer][i] = Math.max(dp[layer][i], cal);
                }
            }
        }
        return dp[n-1][n-1];
    }
}
