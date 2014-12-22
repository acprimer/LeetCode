/**
 * Created by yaodh on 2014/12/20.
 * <p/>
 * LeetCode: Majority Element
 * Link: https://oj.leetcode.com/problems/majority-element/
 * Description:
 * -----------------------------
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * -----------------------------
 * <p/>
 * Tag: Array
 */
public class MajorityElement {
    public int majorityElement(int[] num) {
        int candidate = 0;
        int count = 0;
        for (int x : num) {
            if (count == 0) {
                candidate = x;
                count++;
            } else {
                if (candidate == x) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }
}
