/**
 * Created by yaodh on 2014/11/14.
 *
 * LeetCode: Valid Palindrome
 * Link: https://oj.leetcode.com/problems/valid-palindrome/
 * Description:
 * -----------------------------
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * -----------------------------
 *
 * Tag: Two Pointers
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return true;
        }
        int len = s.length();
        int i=0, j=len-1;
        while(i < j) {
            // Character is powerful!!!
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++; j--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean ans = new ValidPalindrome().isPalindrome("1a2");
        System.out.println(ans);
    }
}
