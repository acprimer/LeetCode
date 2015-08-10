/**
 * Created by yaodh on 2014/11/18.
 *
 * LeetCode: Interleaving String
 * Link: https://oj.leetcode.com/problems/interleaving-string/
 * Description:
 * -----------------------------
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * -----------------------------
 *
 * Tag: Dynamic Programming
 */
public class InterleavingString {
    /*ublic boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int row = s1.length();
        int column = s2.length();
        boolean[][] dp = new boolean[row+1][column+1];
        dp[0][0] = true;
        for(int i=0;i<=row;i++) {
            for(int j=0;j<=column;j++) {
                if(i>=1 && s1.charAt(i-1) == s3.charAt(i+j-1) && dp[i-1][j]) {
                    dp[i][j] = true;
                    continue;
                }
                if(j>=1 && s2.charAt(j-1) == s3.charAt(i+j-1) && dp[i][j-1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[row][column];
    }*/

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int r = s1.length(), c = s2.length();
        boolean[][] dp = new boolean[r+1][c+1];
        dp[0][0] = true;
        for(int i=1;i<=r;i++) {
            dp[i][0] = dp[i-1][0] && (s1.charAt(i-1) == s3.charAt(i-1));
        }
        for(int j=1;j<=c;j++) {
            dp[0][j] = dp[0][j-1] && (s2.charAt(j-1) == s3.charAt(j-1));
        }
        for(int i=1;i<=r;i++) {
            for(int j=1;j<=c;j++) {
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)) || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return dp[r][c];
    }

    public static void main(String[] args) {
        boolean ans = new InterleavingString().isInterleave("a", "b", "ab");
        System.out.println(ans);
    }
}
