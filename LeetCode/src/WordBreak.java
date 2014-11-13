import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yaodh on 2014/11/12.
 *
 * LeetCode: Word Break
 * Link: https://oj.leetcode.com/problems/word-break/
 * Description:
 * -----------------------------
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 * -----------------------------
 *
 * Tag: Dynamic Programming
 */

public class WordBreak {
    // Accepted
    // dynamic programming
    List<Integer>[] hash;
    public boolean wordBreak(String s, Set<String> dict) {
        int n = s.length();
        hash = new ArrayList[n + 1];
        for(int i=0;i<n+1;i++) {
            hash[i] = new ArrayList<Integer>();
        }
        for(String word : dict) {
            for(int i=0;i<n;i++) {
                int idx = s.indexOf(word, i);
                if(idx != -1) {
                    hash[idx].add(idx + word.length());
                    i = idx;
                }
                else {
                    break;
                }
            }
        }

        // tailed[i]: true indicates that substring(0,i-1) can be separated into dictionary words
        boolean[] tailed = new boolean[n + 1];
        for(int i=0;i<n;i++) {
            for(int x : hash[i]) {
                if(i == 0 || tailed[i]) {
                    tailed[x] = true;
                }
            }
        }
        return tailed[n];
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("leet");
        set.add("code");
        boolean ans = new WordBreak().wordBreak("leetcode", set);
        System.out.print(ans);
    }

    // Time Limit Exceeded
//    List<Integer>[] hash;
//    public boolean wordBreak(String s, Set<String> dict) {
//        int n = s.length();
//        hash = new ArrayList[n];
//        for(int i=0;i<n;i++) {
//            hash[i] = new ArrayList<Integer>();
//        }
//        for(String word : dict) {
//            for(int i=0;i<n;i++) {
//                int idx = s.indexOf(word, i);
//                if(idx != -1) {
//                    hash[idx].add(idx + word.length());
//                    i = idx;
//                }
//                else {
//                    break;
//                }
//            }
//        }
//        return dfs(0, n);
//    }
//
//    private boolean dfs(int x, int n) {
//        if(x == n) {
//            return true;
//        }
//        else if(x > n) {
//            return false;
//        }
//        else {
//            for(int y : hash[x]) {
//                if(dfs(y, n)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
