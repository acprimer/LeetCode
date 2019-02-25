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
//    public boolean isMatch(String s, String p) {
//        int i=0,j=0;
//        // i: find the first index of *
//        while(i<p.length() && p.charAt(i)!='*') {
//            if(i>=s.length() || !match(p.charAt(i),s.charAt(i))) return false;
//            i++;
//        }
//        if(i>=p.length()) return i>=s.length();
//        // j: find the last index of *
//        while(j<p.length()) {
//            int pid = p.length()-1-j;
//            int sid = s.length()-1-j;
//            if(p.charAt(pid)=='*') break;
//            if(sid<0 || !match(p.charAt(pid),s.charAt(sid))) return false;
//            j++;
//        }
//        if(i+j>s.length()) return false;
//        return search(s.substring(i,s.length()-j),p.substring(i,p.length()-j));
//    }
//
//    // search p in s
//    public boolean search(String s, String p) {
//        int i,j,start=0;
//        for(i=0,j=0;i<s.length()&&j<p.length();i++) {
//            if(p.charAt(j)=='*') {
//                start = ++j;
//                i--;
//            } else if(match(p.charAt(j),s.charAt(i))) {
//                j++;
//            } else {
//                i-=j-start;
//                j=start;
//            }
//        }
//        while(j<p.length() && p.charAt(j)=='*') {
//            j++;
//        }
//        return j>=p.length();
//    }
//
//    public boolean match(char a, char b) {
//        if (a == '?' || a == b) return true;
//        return false;
//    }

    // DP
    // s=abceb p=*a*b
    //   #abceb
    // # tfffff
    // * tttttt
    // a ftffff
    // * fttttt
    // b ffffft
    public boolean isMatch(String s, String p) {
        s = "#" + s;
        p = "#" + p;
        boolean[][] dp = new boolean[p.length()][s.length()];
        dp[0][0] = true;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*') dp[i][0] = dp[i - 1][0];
            for (int j = 1; j < s.length(); j++) {
                if (p.charAt(i) == '*') dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
                else dp[i][j] = (match(s.charAt(j), p.charAt(i)) && dp[i - 1][j - 1]);
            }
        }
        return dp[p.length() - 1][s.length() - 1];
    }

    public boolean match(char a, char b) {
        return a == b || b == '?';
    }

    public static void main(String[] args) {
        boolean ans = new WildcardMatching().isMatch("b", "?*?");
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
