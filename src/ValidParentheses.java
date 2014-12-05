/**
 * Created by yaodh on 2014/11/28.
 * <p/>
 * LeetCode: Valid Parentheses
 * Link: https://oj.leetcode.com/problems/valid-parentheses/
 * Description:
 * -----------------------------
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * -----------------------------
 * <p/>
 * Tag: Stack
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        char[] stack = new char[s.length() + 1];
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack[++idx] = ch;
            } else {
                switch (ch) {
                    case ')':
                        if (stack[idx] != '(') return false;
                        idx--;
                        break;
                    case ']':
                        if (stack[idx] != '[') return false;
                        idx--;
                        break;
                    case '}':
                        if (stack[idx] != '{') return false;
                        idx--;
                        break;
                }
            }
        }
        return idx == 0;
    }

    public static void main(String[] args) {
        boolean ans = new ValidParentheses().isValid("[]]");
        System.out.println(ans);
    }
}
