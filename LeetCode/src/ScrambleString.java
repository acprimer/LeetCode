/**
 * Created by yaodh on 2014/11/21.
 * <p/>
 * LeetCode: Scramble String
 * Link: https://oj.leetcode.com/problems/scramble-string/
 * Description:
 * -----------------------------
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * Below is one possible representation of s1 = "great":
 *     great
 *    /    \
 *  gr    eat
 * / \    /  \
 *g   r  e   at
 *          / \
 *         a   t
 * To scramble the string, we may choose any non-leaf node and swap its two children.
 * For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".
 *    rgeat
 *   /    \
 *  rg    eat
 * / \    /  \
 *r   g  e   at
 *          / \
 *         a   t
 * We say that "rgeat" is a scrambled string of "great".
 * Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".
 *    rgtae
 *   /    \
 *  rg    tae
 * / \    /  \
 *r   g  ta  e
 *      / \
 *     t   a
 * We say that "rgtae" is a scrambled string of "great".
 * Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 * -----------------------------
 * <p/>
 * Tag: DFS
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2) || s1.equals(new StringBuilder(s2).reverse().toString())) {
            return true;
        }
        int[] hash = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            hash[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            hash[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (hash[i] != 0) return false;
        }
        for (int i = 1; i < s1.length(); i++) {
            int start = 0, end = s1.length(), mid = i;
            if (isScramble(s1.substring(start, mid), s2.substring(start, mid))
                    && isScramble(s1.substring(mid, end), s2.substring(mid, end)))
                return true;
        }
        s2 = new StringBuffer(s2).reverse().toString();
        for (int i = 1; i < s1.length(); i++) {
            int start = 0, end = s1.length(), mid = i;
            if (isScramble(s1.substring(start, mid), s2.substring(start, mid))
                    && isScramble(s1.substring(mid, end), s2.substring(mid, end)))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        boolean ans = new ScrambleString().isScramble("abcd", "dbac");
        System.out.println(ans);
    }
}
