/**
 * Created by yaodh on 2014/11/22.
 * <p/>
 * LeetCode: Search in Rotated Sorted Array II
 * Link: https://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * Description:
 * -----------------------------
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * -----------------------------
 * <p/>
 * Tag: Binary Search
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] A, int target) {
        if (A == null || A.length <= 0) return false;
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (A[mid] == target) return true;
            if (A[left] == target) return true;
            if (A[right] == target) return true;
            if (A[mid] > A[left]) {
                if (target > A[left] && target < A[mid]) {
                    right = mid - 1;
                } else left++;
            } else {
                if (target > A[mid] && target < A[left]) {
                    left = mid + 1;
                } else {
                    right--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean ans = new SearchInRotatedSortedArrayII().search(new int[]{1, 3, 1, 1, 1}, 3);
        System.out.println(ans);
    }
}
