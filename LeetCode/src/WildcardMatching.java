/**
 * Created by yaodh on 2014/11/25.
 */
public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        s = ' ' + s;
        p = ' ' + p;
        boolean[][] dp = new boolean[p.length()][s.length()];
        dp[0][0] = true;
        int last = 0;
        boolean flag = false;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                if(flag) {
                    int tmp = -1;
                    for (int j = last + 1; j < s.length(); j++) {
                        dp[i][j] = dp[i - 1][j - 1] && match(p.charAt(i), s.charAt(j));
                        if (dp[i][j] && tmp == -1) {
                            tmp = j;
                        }
                    }
                    if (tmp == -1) return false;
                    last = tmp;
                }
                else{
                    last++;
                    if(s.length()<=last) return false;
                    dp[i][last] = dp[i - 1][last - 1] && match(p.charAt(i), s.charAt(last));
                    if(dp[i][last]) return false;
                }
                flag = false;
            } else {
                flag = true;
            }
        }
        return dp[p.length() - 1][s.length() - 1];
    }

    public boolean match(char a, char b) {
        if (a == '?' || a == b) return true;
        return false;
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

    public static void main(String[] args) {
        boolean ans = new WildcardMatching().isMatch("a", "aa");
        System.out.println(ans);
    }
}
