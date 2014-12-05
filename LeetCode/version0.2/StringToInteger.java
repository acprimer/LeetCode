/**
 * Created by yaodh on 2014/11/27.
 * <p/>
 * LeetCode: String to Integer (atoi)
 * Link: https://oj.leetcode.com/problems/string-to-integer-atoi/
 * Description:
 * -----------------------------
 * Implement atoi to convert a string to an integer.
 * <p/>
 * Hint: Carefully consider all possible input cases.
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 * You are responsible to gather all the input requirements up front.
 * If no valid conversion could be performed, a zero value is returned.
 * If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * -----------------------------
 * <p/>
 * Tag: Math
 */
public class StringToInteger {
    public int atoi(String str) {
        str = str.trim();
        if (str.length() <= 0) return 0;
        int ans = 0, flag = 1;
        int start = 0;
        if (str.charAt(0) == '+') {
            start = 1;
        }
        if (str.charAt(0) == '-') {
            start = 1;
            flag = -1;
        }
        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) break;
            if (Math.abs(ans) > 214748364
                    || (Math.abs(ans) == 214748364 && str.charAt(i) - '0' > (flag == 1 ? 7 : 8))) {
                if (flag == 1) return Integer.MAX_VALUE;
                return Integer.MIN_VALUE;
            }
            ans = ans * 10 + flag * (str.charAt(i) - '0');
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new StringToInteger().atoi("-1");
        System.out.println(ans);
    }
}
