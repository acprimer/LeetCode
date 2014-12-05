/**
 * Created by yaodh on 2014/11/17.
 *
 * LeetCode: Distinct Subsequences
 * Link: https://oj.leetcode.com/problems/distinct-subsequences/
 * Description:
 * -----------------------------
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string
 * by deleting some (can be none) of the characters without disturbing the relative positions of
 * the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * -----------------------------
 *
 * Tag: Dynamic Programming
 */
public class DistinctSubsequences {
    // Time: O(n^2) Space: O(n^2)
    public int numDistinct(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
        int[][] dp = new int[tLen+2][sLen+2];
        for(int i=0;i<sLen;i++) {
            dp[0][i] = 1;
        }
        for(int i=1;i<=tLen;i++) {
            for(int j=1;j<=sLen;j++) {
                dp[i][j] = dp[i][j-1] + (T.charAt(i-1) == S.charAt(j-1) ? dp[i-1][j-1] : 0);
            }
        }
        return dp[tLen][sLen];
    }
    public static void main(String[] main) {
        int ans = new DistinctSubsequences().numDistinct("rabbbit", "rabbit");
        System.out.println(ans);
    }
}
