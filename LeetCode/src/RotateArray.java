/**
 * Created by yaodh on 2015/3/19.
 * LeetCode: Rotate Array
 * Link: https://leetcode.com/problems/rotate-array/
 * Description:
 * -----------------------------
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * -----------------------------
 * <p/>
 * Tag: Bit
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len <= 0) {
            return;
        }
        k %= len;
        swap(nums, 0, len - k - 1);
        swap(nums, len - k, len - 1);
        swap(nums, 0, len - 1);
    }

    private void swap(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate(a, 3);
        for (int x : a) {
            System.out.println(x);
        }
    }
}
