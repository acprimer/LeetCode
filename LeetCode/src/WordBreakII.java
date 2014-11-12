import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yaodh on 2014/11/12.
 *
 * LeetCode: Word Break II
 * link: https://oj.leetcode.com/problems/word-break-ii/
 * description:
 * Given a string s and a dictionary of words dict,
 * Return all such possible sentences.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * A solution is ["cats and dog", "cat sand dog"].
 *
 * Tag: Dynamic Programming | Backtracking
 */
public class WordBreakII {
    private List<String> ans = new ArrayList<String>();
    private List<Integer>[] wordIndex;
    private String[] dicts;
    public List<String> wordBreak(String s, Set<String> dict) {
        dicts = dict.toArray(new String[dict.size()]);
        int n = s.length();
        List<Integer>[] hash = new ArrayList[n + 1];
        for(int i=0;i<n+1;i++) {
            hash[i] = new ArrayList<Integer>();
        }
        int iterator = 0;
        for(String word : dict) {
            for(int i=0;i<n;i++) {
                int idx = s.indexOf(word, i);
                if(idx != -1) {
                    hash[idx + word.length() - 1].add(idx);
                    hash[idx + word.length() - 1].add(iterator);
                    i = idx;
                }
                else {
                    break;
                }
            }
            iterator++;
        }

        // tailed[i]: true indicates that substring(0,i-1) can be separated into dictionary words
        wordIndex = new ArrayList[n + 1];
        for(int i=0;i<n+1;i++) {
            wordIndex[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<hash[i].size();j+=2) {
                int x = hash[i].get(j);
                int y = hash[i].get(j+1);
                if(x ==0 || wordIndex[x - 1].size() > 0) {
                    wordIndex[i].add(x-1);
                    wordIndex[i].add(y);
                }
            }
        }
        dfs(n-1, "");
        return ans;
    }

    private void dfs(int n, String s) {
        if(n < 0) {
            ans.add(s);
            return;
        }
        for(int i=0;i<wordIndex[n].size();i+=2) {
            int x = wordIndex[n].get(i);
            int idx = wordIndex[n].get(i+1);
            String t = s;
            if(s.length() > 0) {
                t = " " + s;
            }
            t = dicts[idx] + t;
            dfs(x, t);
        }
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        List<String> ans = new WordBreakII().wordBreak("catsanddog", set);
        for(String word : ans) {
            System.out.println(word);
        }
        System.out.println(ans.size());
    }
}
