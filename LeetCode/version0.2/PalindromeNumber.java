/**
 * Created by yaodh on 2014/11/27.
 * <p/>
 * LeetCode: Palindrome Number
 * Link: https://oj.leetcode.com/problems/palindrome-number/
 * Description:
 * -----------------------------
 * Determine whether an integer is a palindrome. Do this without extra space.
 * -----------------------------
 * <p/>
 * Tag: Math
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int tmp = x, pow = 1;
        while (true) {
            tmp /= 10;
            if (tmp > 0) pow *= 10;
            else break;
        }
        while (x != 0) {
            if (x % 10 != x / pow) return false;
            x = (x % pow) / 10;
            pow /= 100;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ans = new PalindromeNumber().isPalindrome(1221);
        System.out.println(ans);
    }
}
