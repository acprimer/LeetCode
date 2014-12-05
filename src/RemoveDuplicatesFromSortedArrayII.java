/**
 * Created by yaodh on 2014/11/21.
 * <p/>
 * LeetCode: Remove Duplicates from Sorted Array II
 * Link: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 * Description:
 * -----------------------------
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * -----------------------------
 * <p/>
 * Tag: LinkedList
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] A) {
        if (A.length <= 0) return 0;
        int count = 0;
        for (int i = 0; i < A.length; ) {
            int first = A[i], duplicate = 0;
            while (i < A.length && A[i] == first) {
                i++;
                duplicate++;
            }
            for (int j = 0; j < duplicate && j < 2; j++) {
                A[count++] = first;
            }
            if (i >= A.length) break;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 1, 2, 2, 3};
        int ans = new RemoveDuplicatesFromSortedArrayII().removeDuplicates(A);
        System.out.println(ans);
        for (int i = 0; i < ans; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
