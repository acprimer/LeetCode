/**
 * Created by yaodh on 2014/1/2.
 * <p/>
 * LeetCode: Regular Expression Matching
 * Link: https://oj.leetcode.com/problems/regular-expression-matching/
 * Description:
 * -----------------------------
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * -----------------------------
 * <p/>
 * Tag: Backtracking DP
 */
public class RegularExpressionMatching {
    /*public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        for(int i=0;i<=p.length();i++) {
            dp[i][0] = true;
        }
        for(int i=0;i<=s.length();i++) {
            dp[0][i] = true;
        }
        int match = 0;
        for(int i=0;i<p.length();i++) {
            // single character
            if(i+1>=p.length() || p.charAt(i+1)!='*') {
                for(int j=match;j<s.length();j++) {
                    dp[i+1][j+1] = dp[i][j] && match(p.charAt(i), s.charAt(j));
                }
                match++;
                continue;
            }
            // .*
            if(i+1<p.length() && p.substring(i,i+2).equals(".*")) {
                for(int j=match;j<s.length();j++) {
                    dp[i+1][j+1] = true;
                }
                continue;
            }
            // a*
            if(i+1<p.length() && p.charAt(i+1)=='*') {
                if(dp[i][match])
                for(int j=match;j<s.length();j++) {
                    if(p.charAt(i)!=s.charAt(j)) break;
                    dp[i+1][j+1] = dp[i][j];
                }
                continue;
            }
        }
    }

    public boolean match(char a, char b){
        if(a=='.' || a==b) return true;
        return false;
    }*/

    // Backtracking
    public boolean isMatch(String s, String p) {
        if (p.length() <= 0) return s.equals(p);
        if (p.length() > 1 && p.charAt(1) == '*') {
            if (p.charAt(0) == '.') {
                for (int i = 0; i <= s.length(); i++) {
                    if (isMatch(s.substring(i), p.substring(2))) {
                        return true;
                    }
                }
                return false;
            }
            if (isMatch(s, p.substring(2))) {
                return true;
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == p.charAt(0)) {
                    if (isMatch(s.substring(i + 1), p.substring(2))) {
                        return true;
                    }
                } else break;
            }
        } else {
            if (s.length() >= 1 &&
                    (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))) {
                return isMatch(s.substring(1), p.substring(1));
            } else return false;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean ans = new RegularExpressionMatching().isMatch("", ".*");
        System.out.println(ans);
    }
}
