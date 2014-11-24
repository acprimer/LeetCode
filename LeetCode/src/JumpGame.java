/**
 * Created by yaodh on 2014/11/24.
 * <p/>
 * LeetCode: Jump Game
 * Link: https://oj.leetcode.com/problems/jump-game/
 * Description:
 * -----------------------------
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * -----------------------------
 * <p/>
 * Tag: Greedy
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        if (A.length <= 1) return true;
        int maxLen = 0;
        for (int i = 0; i < A.length && i <= maxLen; i++) {
            maxLen = Math.max(maxLen, i + A[i]);
            if (maxLen >= A.length - 1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean ans = new JumpGame().canJump(new int[]{0, 1});
        System.out.println(ans);
    }
}
