/**
 * Created by yaodh on 15/7/30.
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0, ans = nums.length + 1, last = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= s) {
                ans = Math.min(ans, i - last + 1);  // update the min length
                sum -= nums[last++];
            }
        }
        return ans == nums.length + 1 ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{1,3}));
    }
}
