/**
 * Created by yaodh on 2014/11/21.
 * <p/>
 * LeetCode: Remove Duplicates from Sorted Array
 * Link: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Description:
 * -----------------------------
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * -----------------------------
 * <p/>
 * Tag: LinkedList
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] A) {
        if (A.length <= 0) return 0;
        int count = 1;
        for (int i = 1; i < A.length; i++) {
            while (i < A.length && A[i] == A[i - 1]) i++;
            if (i >= A.length) break;
            A[count++] = A[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 1};
        int ans = new RemoveDuplicatesFromSortedArray().removeDuplicates(A);
        System.out.println(ans);
        for (int i = 0; i < ans; i++) {
            System.out.println(A[i]);
        }
    }
}
