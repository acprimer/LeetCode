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
    public boolean isInterleave(String s1, String s2, String s3) {
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
    }

    public static void main(String[] args) {
        boolean ans = new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbbaccc");
        System.out.println(ans);
    }
}
