/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Edit Distance
 * Link: https://oj.leetcode.com/problems/edit-distance/
 * Description:
 * -----------------------------
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2.
 * (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * -----------------------------
 * <p/>
 * Tag: Dynamic Programming
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0) return len2;
        if (len2 == 0) return len1;
        int[][] dp = new int[len1][len2];
        boolean flag = false;
        for (int i = 0; i < len1; i++) {
            flag = flag || (word1.charAt(i) == word2.charAt(0));
            dp[i][0] = i + 1 - (flag ? 1 : 0);
        }
        flag = false;
        for (int i = 0; i < len2; i++) {
            flag = flag || (word1.charAt(0) == word2.charAt(i));
            dp[0][i] = i + 1 - (flag ? 1 : 0);
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                dp[i][j] = dp[i - 1][j - 1] + (word1.charAt(i) == word2.charAt(j) ? 0 : 1);
                dp[i][j] = Math.min(dp[i][j], Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);
            }
        }
        return dp[len1 - 1][len2 - 1];
    }

    public static void main(String[] args) {
        int ans = new EditDistance().minDistance("a", "ab");
        System.out.println(ans);
    }
}
