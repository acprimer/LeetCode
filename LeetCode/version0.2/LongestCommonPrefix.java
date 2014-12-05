/**
 * Created by yaodh on 2014/11/28.
 * <p/>
 * LeetCode: Longest Common Prefix
 * Link: https://oj.leetcode.com/problems/longest-common-prefix/
 * Description:
 * -----------------------------
 * Write a function to find the longest common prefix string amongst an array of strings.
 * -----------------------------
 * <p/>
 * Tag: String
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String ans = new LongestCommonPrefix().longestCommonPrefix(new String[]{"", "abc", "abc"});
        System.out.println(ans);
    }
}
