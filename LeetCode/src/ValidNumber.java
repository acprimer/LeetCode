/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Valid Number
 * Link: https://oj.leetcode.com/problems/valid-number/
 * Description:
 * -----------------------------
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous.
 * You should gather all requirements up front before implementing one.
 * -----------------------------
 * <p/>
 * Tag: Math String
 */
public class ValidNumber {
    // valid number: 0 1 0.1 1.0 .1 1e10 +0 -0 -1e-10
    // invalid number: 1e1.0 +-.
    public boolean isNumber(String s) {
        s = s.trim();
        if (s == null || s.length() <= 0) return false;
        int eIndex = s.indexOf('e');
        if (eIndex != -1) {
            return isFloat(s.substring(0, eIndex)) && isInteger(s.substring(eIndex + 1), true);
        }
        eIndex = s.indexOf('E');
        if (eIndex != -1) {
            return isFloat(s.substring(0, eIndex)) && isInteger(s.substring(eIndex + 1), true);
        }
        return isFloat(s);
    }

    // flag = true:  +1 is valid
    // flag = false: +1 is invalid
    public boolean isInteger(String s, boolean flag) {
        if (s.equals("")) return false;
        if (flag && (s.charAt(0) == '+' || s.charAt(0) == '-')) {
            s = s.substring(1);
        }
        if (s.equals("")) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }

    public boolean isFloat(String s) {
        if (s.equals("")) return false;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            s = s.substring(1);
        }
        int index = s.indexOf('.');
        if (index == -1) return isInteger(s, false);
        if (index == 0) return isInteger(s.substring(1), false);
        if (index == s.length() - 1) return isInteger(s.substring(0, s.length() - 1), false);
        if (!isInteger(s.substring(0, index), false)) return false;
        return isInteger(s.substring(index + 1), false);
    }

    public static void main(String[] args) {
        boolean ans = new ValidNumber().isNumber("32.e-80123");
        System.out.println(ans);
    }
}
