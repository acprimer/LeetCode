import java.util.Arrays;

/**
 * Created by yaodh on 2014/12/2.
 * <p/>
 * LeetCode: 3Sum Closest
 * Link: https://oj.leetcode.com/problems/3sum-closest/
 * Description:
 * -----------------------------
 * Given an array S of n integers, find three integers in S
 * such that the sum is closest to a given number, target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * -----------------------------
 * <p/>
 * Tag: Sort TwoPointers
 */

public class ThreeSumClosest {
    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int ans = num[0] + num[1] + num[2];
        for (int i = 0; i < num.length - 2; i++) {
            int sum = num[i] + twoSum(num, i + 1, num.length - 1, target - num[i]);
            if (Math.abs(sum - target) < Math.abs(ans - target)) {
                ans = sum;
            }
        }
        return ans;
    }

    public int twoSum(int[] num, int start, int end, int target) {
        int ans = num[start] + num[end];
        while (start < end) {
            if (Math.abs(num[start] + num[end] - target) < Math.abs(ans - target)) {
                ans = num[start] + num[end];
            }
            if (num[start] + num[end] == target) {
                return target;
            }
            if (num[start] + num[end] > target) {
                end--;
            } else start++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new ThreeSumClosest().threeSumClosest(new int[]{0, 1, 2}, 0);
        System.out.println(ans);
    }
}
