import java.util.Arrays;

public class TargetSum {

    public static void main(String[] args) {
        System.out.println(new TargetSum().findTargetSumWays(new int[]{31,4,45,3,44,49,28,6,22,24,40,25,13,46,17,10,2,38,25,15}, 25));
    }

    // TLE
    /*public int findTargetSumWays(int[] nums, int sum) {
        if (nums == null || nums.length == 0) return 0;

        int ans = 0;
        int len = nums.length;
        int[] curSum = new int[len];
        curSum[len - 1] = nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            curSum[i] = curSum[i+1] + nums[i];
        }
        for (int i = 0; i < (1 << len); i++) {
            if (checkSum(nums, curSum, sum, i)) ans++;
        }

        return ans;
    }

    private boolean checkSum(int[] nums, int[] curSum, int sum, int bit) {
        int cal = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - cal > curSum[i] || sum - cal < -curSum[i]) return false;
            int flag = 1;
            if ((bit & (1<<i)) == 0) {
                flag = -1;
            }
            cal += flag * nums[i];
        }
        return cal == sum;
    }*/

    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return target == 0 ? 1 : 0;
        }
        return find(nums, target, 0);
    }

    public int find(int[] nums, int target, int start) {
        if (start >= nums.length) {
            return target == 0 ? 1 : 0;
        }

        int a = find(nums, target - nums[start], start + 1);
        int b = find(nums, target + nums[start], start + 1);
        return a + b;
    }
}
