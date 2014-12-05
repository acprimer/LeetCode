/**
 * Created by yaodh on 2014/11/22.
 * <p/>
 * LeetCode: Search in Rotated Sorted Array
 * Link: https://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 * Description:
 * -----------------------------
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * -----------------------------
 * <p/>
 * Tag: Binary Search
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A == null || A.length <= 0) return -1;
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (A[mid] == target) return mid;
            if (A[left] == target) return left;
            if (A[right] == target) return right;
            if (A[mid] > A[left]) {
                if (target > A[left] && target < A[mid]) {
                    right = mid - 1;
                } else left = mid + 1;
            } else {
                if (target > A[mid] && target < A[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int ans = new SearchInRotatedSortedArray().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5);
        System.out.println(ans);
    }
}
