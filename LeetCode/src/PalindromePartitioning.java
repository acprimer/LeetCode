import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/14.
 *
 * LeetCode: Palindrome Partitioning
 * Link: https://oj.leetcode.com/problems/palindrome-partitioning/
 * Description:
 * -----------------------------
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return [["aa","b"],["a","a","b"]]
 * -----------------------------
 *
 * Tag: Backtracking
 */
public class PalindromePartitioning {
    List<List<String>> pList;
    public List<List<String>> partition(String s) {
        pList = new ArrayList<List<String>>();
        dfs(s, null);
        return pList;
    }

    private void dfs(String s, List<String> list) {
        for(int i=0;i<s.length();i++) {
            String palindromeString = s.substring(0, i+1);
            if(testPalindrome(palindromeString)) {
                // copy list to cur, to avoid being modified
                // because we will use list later(in the next loop).
                List<String> cur = new ArrayList<String>();
                if(list != null) {
                    cur.addAll(list);
                }
                cur.add(palindromeString);
                // backtracking stops
                if(i == s.length() - 1) {
                    pList.add(cur);
                    return ;
                }
                dfs(s.substring(i+1, s.length()), cur);
            }
        }
    }

    // test String s is palindrome or not
    private boolean testPalindrome(String s) {
        int i=0, j=s.length()-1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> lists = new PalindromePartitioning().partition("aab");
        for(List<String> list : lists) {
            for(String s : list) {
                System.out.print(s + ",");
            }
            System.out.println();
        }
    }
}
