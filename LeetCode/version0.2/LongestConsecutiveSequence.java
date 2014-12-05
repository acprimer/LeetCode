import java.util.Arrays;

/**
 * Created by yaodh on 2014/11/13.
 *
 * LeetCode: Longest Consecutive Sequence
 * Link: https://oj.leetcode.com/problems/longest-consecutive-sequence/
 * Description:
 * -----------------------------
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * -----------------------------
 *
 * Tag: Array
 */
public class LongestConsecutiveSequence {

    // using sort: O(nlgn)
    public int longestConsecutive(int[] num) {
        if(num.length <= 1) {
            return num.length;
        }
        Arrays.sort(num);
        int ans = 1, pre = num[0];
        int cnt = 1;
        for(int i=1;i<num.length;i++) {
            if(num[i] == pre + 1) {
                cnt++;
                pre = num[i];
                ans = Math.max(ans, cnt);
            }
            else if(num[i] == pre) {
                while (i<num.length && num[i] == pre) {
                    i++;
                }
                if(i >= num.length) break;
                i--;
            }
            else {
                cnt = 1;
                pre = num[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new LongestConsecutiveSequence().longestConsecutive(new int[]{0, 0});
        System.out.print(ans);
    }
}
