import java.util.Arrays;

/**
 * Created by yaodh on 2017/12/14.
 */
public class SingleNumberIII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SingleNumberIII().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }

    public int[] singleNumber(int[] nums) {
        int x = 0;
        for (int n : nums) {
            x ^= n;
        }
        x &= -x;
        int[] ans = new int[2];
        for (int n : nums) {
            if ((n & x) > 0) {
                ans[0] ^= n;
            } else {
                ans[1] ^= n;
            }
        }
        return ans;
    }
}
