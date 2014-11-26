/**
 * Created by yaodh on 2014/11/27.
 * <p/>
 * LeetCode: Search Insert Position
 * Link: https://oj.leetcode.com/problems/search-insert-position/
 * Description:
 * -----------------------------
 * Given a sorted array and a target value, return the index if the target is found. If not,
 * return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * -----------------------------
 * <p/>
 * Tag: Binary Search
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if (A.length <= 0) return 0;
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (A[mid] == target) return mid;
            else if (A[mid] < target) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        int ans = new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 4);
        System.out.println(ans);
    }
}
