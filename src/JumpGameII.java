/**
 * Created by yaodh on 2014/11/25.
 * <p/>
 * LeetCode: Jump Game II
 * Link: https://oj.leetcode.com/problems/jump-game-ii/
 * Description:
 * -----------------------------
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * -----------------------------
 * <p/>
 * Tag: Greedy
 */
public class JumpGameII {
    public int jump(int[] A) {
        if (A.length <= 1) return 0;
        int step = 0;
        int maxLen = 0, maxLenNextStep = 0;
        for (int i = 0; i < A.length; i++) {
            maxLenNextStep = Math.max(maxLenNextStep, i + A[i]);
            if (maxLenNextStep >= A.length - 1) return step + 1;
            if (i == maxLen) {
                maxLen = maxLenNextStep;
                maxLenNextStep = 0;
                step++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int ans = new JumpGameII().jump(new int[]{2, 3, 1, 1, 4});
        System.out.println(ans);
    }
}
