import java.util.Arrays;

/**
 * Created by yaodh on 15/7/19.
 */
public class ProductOfArrayExceptSelf {
    // O(n) + O(n)
//    public int[] productExceptSelf(int[] nums) {
//        int n = nums.length;
//        int[][] dp = new int[2][n];
//        dp[0][0] = nums[0];
//        dp[1][n-1] = nums[n-1];
//        for(int i=1;i<n;i++) {
//            dp[0][i] = dp[0][i-1] * nums[i];
//        }
//        for(int i=n-2;i>=0;i--) {
//            dp[1][i] = dp[1][i+1] * nums[i];
//        }
//        int[] ans = new int[n];
//        for(int i=0;i<n;i++) {
//            ans[i] = 1;
//            ans[i] *= (i == 0 ? 1 : dp[0][i-1]);
//            ans[i] *= (i == n-1 ? 1 : dp[1][i+1]);
//        }
//        return ans;
//    }

    // O(n) + O(1)
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = nums[0];
        for(int i=1;i<n-1;i++) {
            ans[i] = ans[i-1] * nums[i];
        }
        ans[n-1] = ans[n-2];
        int product = 1;
        for(int i=n-2;i>0;i--) {
            product *= nums[i+1];
            ans[i] = product * ans[i-1];
        }
        ans[0] = product * nums[1];
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(ans));
    }
}
