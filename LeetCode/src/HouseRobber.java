/**
 * Created by yaodh on 2015/4/16.
 */
public class HouseRobber {
    public int rob(int[] num) {
        int n = num.length, ans = 0;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            dp[i] = num[i];
            for(int j = i - 2; j >= 0; j--) {
                dp[i] = Math.max(dp[i], dp[j] + num[i]);
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
