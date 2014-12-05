/**
 * Created by yaodh on 2014/12/5.
 * <p/>
 * LeetCode: Find Peak Element
 * Link: https://oj.leetcode.com/problems/find-peak-element/
 * Description:
 * -----------------------------
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * -----------------------------
 * <p/>
 * Tag: BinarySearch
 */
public class FindPeakElement {
    public int findPeakElement(int[] num) {
        int n = num.length;
        if (n <= 1) return 0;
        // handle the first and last element in num[]
        if (num[0] > num[1]) return 0;
        if (num[n - 1] > num[n - 2]) return n - 1;
        int left = 1, right = n - 2;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
                return mid;
            } else if (num[mid] > num[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    /*public int findPeakElement(int[] num) {
        int n = num.length;
        if (n <= 1) return 0;
        if (num[0] > num[1]) return 0;
        for (int i = 1; i < n - 1; i++) {
            if (num[i] > num[i - 1] && num[i] > num[i + 1]) {
                return i;
            }
        }
        return n - 1;
    }*/

    public static void main(String[] args) {
        int ans = new FindPeakElement().findPeakElement(new int[]{2, 1});
        System.out.println(ans);
    }
}
