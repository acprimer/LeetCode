import java.util.Arrays;

/**
 * Created by yaodh on 2015/4/23.
 * <p/>
 * LeetCode: Longest Substring Without Repeating Characters
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Description:
 * -----------------------------
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3.
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * -----------------------------
 * <p/>
 * Tag: Hash Two Pointers
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int[] idx = new int[256];
        Arrays.fill(idx, -1);
        int ans = 0, start = -1;
        for (int i = 0; i < s.length(); i++) {
            int ch = s.charAt(i);
            if (idx[ch] > start) {
                start = idx[ch];
            } else {
                ans = Math.max(ans, i - start);
            }
            idx[ch] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("t");
        System.out.println(ans);
    }
}
