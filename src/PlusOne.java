/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Plus One
 * Link: https://oj.leetcode.com/problems/plus-one/
 * Description:
 * -----------------------------
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * -----------------------------
 * <p/>
 * Tag: Math
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 1;
        for (int i = len - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        int[] ans = new int[len + carry];
        if (carry > 0) ans[0] = 1;
        for (int i = carry; i < carry + len; i++) {
            ans[i] = digits[i - carry];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = new PlusOne().plusOne(new int[]{9});
        for (int x : ans) {
            System.out.print(x);
        }
    }
}
