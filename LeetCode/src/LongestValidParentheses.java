/**
 * Created by yaodh on 2014/11/12.
 *
 * LeetCode: Longest Valid Parentheses
 * Link: https://oj.leetcode.com/problems/longest-valid-parentheses/
 * Description:
 * -----------------------------
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * -----------------------------
 *
 * Tag: Greedy
 */

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int[] len = new int[n+1];
        int ans = 0;
        for(int i=1;i<n;i++) {      // NOTE: starting the loop from index 1, not from 0
            char ch = s.charAt(i);
            if(ch == ')') {
                int preIndex = i-1-len[i-1];
                // we need 2 conditions
                if(preIndex >=0 && s.charAt(preIndex) == '(') {
                    if(preIndex - 1 >= 0) {
                        len[i] = len[preIndex - 1];
                    }
                    len[i] += len[i-1] + 2;
                }
            }
            ans = Math.max(ans, len[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new LongestValidParentheses().longestValidParentheses(")()())");
        System.out.print(ans);
    }

    public int longestValidParentheses2(String s) {
        int n = s.length();
        int[] len = new int[n+1];
        int ans = 0;
        for(int i=0;i<n;i++) {      // loop from index 0
            char ch = s.charAt(i);
            if(ch == ')') {
                // look at here: we need 3 conditions
                // we must check i-1>=0 first
                if(i-1>=0 && i-1-len[i-1] >=0 && s.charAt(i-1-len[i-1]) == '(') {
                    if(i-2-len[i-1] >= 0) {
                        len[i] = len[i-2-len[i-1]];
                    }
                    len[i] += len[i-1] + 2;
                }
            }
            if(len[i] > ans) {
                ans = len[i];
            }
        }
        return ans;
    }
}
