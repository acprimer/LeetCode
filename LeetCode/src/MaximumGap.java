import java.util.Arrays;

/**
 * Created by yaodh on 2014/12/14.
 * <p/>
 * LeetCode: Maximum Gap
 * Link: https://oj.leetcode.com/problems/maximum-gap/
 * Description:
 * -----------------------------
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * -----------------------------
 * <p/>
 * Tag: BinarySearch
 */
public class MaximumGap {
    // O(nlgn)
    public int maximumGap(int[] num) {
        if (num.length < 2) return 0;
        Arrays.sort(num);
        int ans = 0;
        for (int i = 1; i < num.length; i++) {
            ans = Math.max(ans, num[i] - num[i - 1]);
        }
        return ans;
    }
}
