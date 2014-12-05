/**
 * Created by yaodh on 2014/11/22.
 * <p/>
 * LeetCode: Minimum Window Substring
 * Link: https://oj.leetcode.com/problems/minimum-window-substring/
 * Description:
 * -----------------------------
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 * -----------------------------
 * <p/>
 * Tag: String
 */
public class MinimumWindowSubstring {
    int[] hash = new int[58];
    int[] wordHash = new int[58];

    public String minWindow(String S, String T) {
        if (S == null || T == null || T.length() == 0 || S.length() < T.length()) {
            return "";
        }
        for (int i = 0; i < T.length(); i++) {
            hash[T.charAt(i) - 'A']++;
        }

        int count = 0, start = 0, end = 0;
        int minLen = S.length() + 1, minStart = 0, minEnd = 0;
        while (end < S.length()) {
            if(hash[S.charAt(end) - 'A'] == 0) {
                end++;
                continue;
            }
            wordHash[S.charAt(end) - 'A']++;
            if (wordHash[S.charAt(end) - 'A'] <= hash[S.charAt(end) - 'A']) {
                count++;
                if (count == T.length()) {
                    // find a window, then shrink the window
                    start = shrink(S, start, end);
                    if (end - start < minLen) {
                        minLen = end - start;
                        minStart = start;
                        minEnd = end;
                    }
                    wordHash[S.charAt(start++) - 'A']--;
                    count--;
                }
            }
            ++end;
        }
        return minLen > S.length() ? "" : S.substring(minStart, minEnd + 1);
    }

    private int shrink(String S, int start, int end) {
        for (int i = start; i <= end; i++) {
            if(hash[S.charAt(i) - 'A'] == 0) continue;
            if (wordHash[S.charAt(i) - 'A'] - 1 >= hash[S.charAt(i) - 'A']) {
                wordHash[S.charAt(i) - 'A']--;
            } else return i;
        }
        return start;
    }

    public static void main(String[] args) {
        String ans = new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC");
        System.out.println(ans);
    }
}
