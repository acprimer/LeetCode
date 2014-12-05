/**
 * Created by yaodh on 2014/11/20.
 *
 * LeetCode: Decode Ways
 * Link: https://oj.leetcode.com/problems/decode-ways/
 * Description:
 * -----------------------------
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example, Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * -----------------------------
 *
 * Tag: Dynamic Programming
 */
public class DecodeWays {
    public int numDecodings(String s) {
        // be careful of '0'
        // "01" is illegal
        if(s == null || s.length() <= 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0] = dp[1] = 1;
        for(int i=1;i<s.length();i++) {
            int num = (s.charAt(i-1) - '0') * 10 + s.charAt(i) - '0';
            if(s.charAt(i-1) == '0') num = 27;
            dp[i+1] = (s.charAt(i) != '0' ? dp[i] : 0) + (num <= 26 ? dp[i-1] : 0);
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {
        int ans = new DecodeWays().numDecodings("1301");
        System.out.println(ans);
    }
}
