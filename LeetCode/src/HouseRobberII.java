/**
 * Created by yaodh on 15/7/31.
 */
public class HouseRobberII {
    public int rob(int[] num, int start, int end) {
        int n = end - start, ans = 0;
        int[] dp = new int[n];
        for (int i = start; i < end; i++) {
            dp[i - start] = num[i];
            for (int j = i - 2; j >= start; j--) {
                dp[i - start] = Math.max(dp[i - start], dp[j - start] + num[i]);
            }
            ans = Math.max(ans, dp[i - start]);
        }
        return ans;
    }
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 1), rob(nums, 1, nums.length));
    }

    public static void main(String[] args) {
        System.out.println(new HouseRobberII().rob(new int[]{1}));
    }
}
