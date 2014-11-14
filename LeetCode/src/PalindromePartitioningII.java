/**
 * Created by yaodh on 2014/11/14.
 *
 * LeetCode: Palindrome Partitioning II
 * Link: https://oj.leetcode.com/problems/palindrome-partitioning-ii/
 * Description:
 * -----------------------------
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * -----------------------------
 *
 * Tag: Dynamic Programming
 */
public class PalindromePartitioningII {

    // Time: O(n^2) Space: O(n^2)
    public int minCut(String s) {
        int len = s.length();
        // palindrome[i][j] : substring(i,j) is palindrome or not?
        boolean[][] palindrome = new boolean[len][len];
        // calculate palindrome[][]
        for(int i=0;i<len;i++) {
            palindrome[i][i] = true;
        }
        for(int i=1;i<len;i++) {
            if(s.charAt(i-1) == s.charAt(i)) {
                palindrome[i-1][i] = true;
            }
        }
        for(int k=2;k<len;k++) {
            for(int i=0;i+k<len;i++) {
                int j = i+k;
                if(s.charAt(i) == s.charAt(j) && palindrome[i+1][j-1]) {
                    palindrome[i][j] = true;
                }
            }
        }

        int[] dp = new int[len];
        // each character is palindrome, so init state is dp[i] = i;
        for(int i=0;i<len;i++) {
            dp[i] = i;
        }
        for(int i=0;i<len;i++) {
            for(int j=i;j<len;j++) {
                if(palindrome[i][j]) {
                    if(i==0) dp[j] = 0;
                    else dp[j] = Math.min(dp[j], dp[i-1] + 1);
                }
            }
        }
        return dp[len-1];
    }


    public static void main(String[] args) {
        int ans = new PalindromePartitioningII().minCut("aab");
        System.out.println(ans);
    }
}
