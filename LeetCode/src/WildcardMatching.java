/**
 * Created by yaodh on 2014/12/3.
 * <p/>
 * LeetCode: Wildcard Matching
 * Link: https://oj.leetcode.com/problems/wildcard-matching/
 * Description:
 * -----------------------------
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * -----------------------------
 * <p/>
 * Tag: String
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        int i = 0, j = 0, start = j;
        boolean flag = false;
        for (; i < s.length() && j < p.length(); i++) {
            if (p.charAt(j) == '*') {
                j++;
                start = j;
                flag = true;
                i--;
            } else if (match(p.charAt(j), s.charAt(i))) {
                j++;
            } else {
                if (start == 0) return false;
                i -= j - start;
                j = start;
            }
        }
        for (; j < p.length(); j++) {
            if (p.charAt(j) != '*') return false;
            else flag = true;
        }
        if (!flag) return i >= s.length();
        for (i = 0; ; i++) {
            if (p.charAt(p.length() - 1 - i) == '*') return true;
            if (!match(p.charAt(p.length() - 1 - i), s.charAt(s.length() - 1 - i))) return false;
        }
    }

    public boolean match(char a, char b) {
        if (a == '?' || a == b) return true;
        return false;
    }

    public static void main(String[] args) {
        boolean ans = new WildcardMatching().isMatch("aac", "*ac");
        System.out.println(ans);
    }

    // TLE
    /*public boolean isMatch(String s, String p) {
        if (p.length() <= 0) return s.equals(p);
        if (p.charAt(0) == '*') {
            for (int i = 0; i <= s.length(); i++) {
                if (isMatch(s.substring(i), p.substring(1))) {
                    return true;
                }
            }
            return false;
        }
        if (s.length() >= 1 && match(p.charAt(0), s.charAt(0)) && isMatch(s.substring(1), p.substring(1))) {
            return true;
        }
        return false;
    }*/
}
