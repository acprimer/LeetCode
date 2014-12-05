import java.math.BigInteger;

/**
 * Created by yaodh on 2014/11/25.
 * <p/>
 * LeetCode: Multiply Strings
 * Link: https://oj.leetcode.com/problems/multiply-strings/
 * Description:
 * -----------------------------
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 * -----------------------------
 * <p/>
 * Tag: String
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        char[] ans = new char[len1 + len2];
        int len3 = ans.length;
        for (int i = 0; i < len3; i++) {
            ans[i] = '0';
        }
        for (int i = 0; i < num1.length(); i++) {
            int carry = 0;
            for (int j = 0; j < num2.length(); j++) {
                int product = ans[len3 - 1 - i - j] - '0' + (num1.charAt(len1 - 1 - i) - '0') * (num2.charAt(len2 - 1 - j) - '0') + carry % 10;
                ans[len3 - 1 - i - j] = (char) ((product % 10) + '0');
                carry = product / 10;
            }
            ans[len3 - 1 - i - num2.length()] = (char) (carry + '0');
            int j = 0;
            while (carry > 0) {
                ans[len3 - 1 - i - num2.length() - j] = (char) (carry % 10 + '0');
                j++;
                carry /= 10;
            }
        }
        int start = 0;
        while (start < len3 - 1 && ans[start] == '0') {
            start++;
        }
        return new String(ans).substring(start);
    }

    // using java BigInteger class
    /*public String multiply(String num1, String num2) {
        BigInteger b1 = BigInteger.ZERO;
        BigInteger b2 = BigInteger.ZERO;
        for (int i = 0; i < num1.length(); i++) {
            b1 = b1.multiply(BigInteger.TEN).add(BigInteger.valueOf(num1.charAt(i) - '0'));
        }
        for (int i = 0; i < num2.length(); i++) {
            b2 = b2.multiply(BigInteger.TEN).add(BigInteger.valueOf(num2.charAt(i) - '0'));
        }
        b1 = b1.multiply(b2);
        return b1.toString();
    }*/

    public static void main(String[] args) {
        String ans = new MultiplyStrings().multiply("3120", "358");
        System.out.println(ans);
    }
}
