/**
 * Created by yaodh on 2015/4/16.
 * <p>
 * LeetCode: House Robber
 * Link: https://leetcode.com/problems/house-robber/
 * Description:
 * -----------------------------
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed,
 * the only constraint stopping you from robbing each of them is that
 * adjacent houses have security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * -----------------------------
 * Tag: DP
 */
public class HouseRobber {
//    public int rob(int[] num) {
//        int n = num.length, ans = 0;
//        int[] dp = new int[n];
//        for (int i = 0; i < n; i++) {
//            dp[i] = num[i];
//            for (int j = i - 2; j >= 0; j--) {
//                dp[i] = Math.max(dp[i], dp[j] + num[i]);
//            }
//            ans = Math.max(ans, dp[i]);
//        }
//        return ans;
//    }

    public int rob(int[] num) {
        if (num == null || num.length <= 0) return 0;
        int n = num.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = (i >= 2 ? dp[i - 2] : 0);
            int y = (i >= 3 ? dp[i - 3] : 0);
            dp[i] = Math.max(x, y) + num[i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobber().rob(new int[]{1, 2, 3, 4, 5}));
    }
}
