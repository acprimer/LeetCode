/**
 * Created by yaodh on 2014/11/28.
 * <p/>
 * LeetCode: Implement strStr()
 * Link: https://oj.leetcode.com/problems/implement-strstr/
 * Description:
 * -----------------------------
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * -----------------------------
 * <p/>
 * Tag: String
 */
public class ImplementStrStr {
    // TLE
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = i + 1;
                while (j < haystack.length() && j - i < needle.length() && haystack.charAt(j) == needle.charAt(j - i)) {
                    j++;
                }
                if (j - i >= needle.length()) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int ans = new ImplementStrStr().strStr("a", "");
        System.out.println(ans);
    }
}
