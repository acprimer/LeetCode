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
    // space: O(1)
    public int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != i + 1 && A[A[i]-1] != A[i]) {
                swap(A, i, A[i] - 1);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i + 1) return i + 1;
        }
        return A.length + 1;
    }

    private void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    // space: O(n)
    /*public int firstMissingPositive(int[] A) {
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
    }*/

    public static void main(String[] args) {
        int ans = new FirstMissingPositive().firstMissingPositive(new int[]{1, 1});
        System.out.println(ans);
    }
}
