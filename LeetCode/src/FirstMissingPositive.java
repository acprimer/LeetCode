/**
 * Created by yaodh on 2014/11/29.
 * <p/>
 * LeetCode: First Missing Positive
 * Link: https://oj.leetcode.com/problems/first-missing-positive/
 * Description:
 * -----------------------------
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * Your algorithm should run in O(n) time and uses constant space.
 * -----------------------------
 * <p/>
 * Tag: Array
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int[] map = new int[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && A[i] <= A.length) {
                map[A[i]] = A[i];
            }
        }
        for (int i = 1; i <= A.length; i++) {
            if (map[i] != i) return i;
        }
        return A.length + 1;
    }

    public static void main(String[] args) {
        int ans = new FirstMissingPositive().firstMissingPositive(new int[]{1, 2});
        System.out.println(ans);
    }
}
