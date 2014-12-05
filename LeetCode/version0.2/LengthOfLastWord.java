/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Length of Last Word
 * Link: https://oj.leetcode.com/problems/length-of-last-word/
 * Description:
 * -----------------------------
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example,
 * Given s = "Hello World",
 * return 5.
 * -----------------------------
 * <p/>
 * Tag: String
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.equals("")) return 0;
        int p = 0, q = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            p = q = i;
            while (q < s.length() && s.charAt(q) != ' ') q++;
            i = --q;
        }
        return q - p + 1;
    }

    public static void main(String[] args) {
        int ans = new LengthOfLastWord().lengthOfLastWord(" ");
        System.out.println(ans);
    }
}
