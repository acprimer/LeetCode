/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Add Binary
 * Link: https://oj.leetcode.com/problems/add-binary/
 * Description:
 * -----------------------------
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * -----------------------------
 * <p/>
 * Tag: Math
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += a.charAt(i) - '0';
            if (j >= 0) sum += b.charAt(j) - '0';
            builder.append(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        String ans = new AddBinary().addBinary("0", "0");
        System.out.println(ans);
    }
}
