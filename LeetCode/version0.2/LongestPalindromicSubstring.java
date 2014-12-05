/**
 * Created by yaodh on 2014/11/14.
 *
 * LeetCode: Longest Palindromic Substring
 * Link: https://oj.leetcode.com/problems/longest-palindromic-substring/
 * Description:
 * -----------------------------
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * -----------------------------
 *
 * Tag: Dynamic Programming
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        int len = s.length();
        // We just record start and end index of the longest palindromic substring
        int start = 0, end = 0; // Don't use substring() in the middle in case of TLE
        // palindrome[i][j] : substring(i,j) is palindrome or not?
        boolean[][] palindrome = new boolean[len][len];
        // length = 1
        for(int i=0;i<len;i++) {
            palindrome[i][i] = true;
        }
        // length = 2
        for(int i=1;i<len;i++) {
            if(s.charAt(i-1) == s.charAt(i)) {
                palindrome[i-1][i] = true;
                start = i-1; end = i+1;
            }
        }
        // length = k (k=2..len)
        for(int k=2;k<len;k++) {
            for(int i=0;i+k<len;i++) {
                int j = i+k;
                if(s.charAt(i) == s.charAt(j) && palindrome[i+1][j-1]) {
                    palindrome[i][j] = true;
                    start = i; end = j+1;
                }
            }
        }
        return s.substring(start, end);
    }

    public static void main(String[] args) {
        String s = new LongestPalindromicSubstring().longestPalindrome("aab");
        System.out.println(s);
    }
}
