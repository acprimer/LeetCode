import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yaodh on 2014/12/2.
 * <p/>
 * LeetCode: Substring with Concatenation of All Words
 * Link: https://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 * Description:
 * -----------------------------
 * You are given a string, S, and a list of words, L, that are all of the same length.
 * Find all starting indices of substring(s) in S
 * that is a concatenation of each word in L exactly once and without any intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 * -----------------------------
 * <p/>
 * Tag: Hash
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> ans = new ArrayList<Integer>();
        if (L.length <= 0) return ans;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < L.length; i++) {
            updateMap(map, L[i]);
        }
        int len = L[0].length();
        Map<String, Integer> curMap = new HashMap<String, Integer>();
        for (int offset = 0; offset < len; offset++) {
            int count = 0;
            curMap.clear();
            for (int j = offset; j + len <= S.length(); j += len) {
                String pattern = S.substring(j, j + len);
                if (!map.containsKey(pattern)) {
                    curMap.clear();
                    count = 0;
                    continue;
                }
                updateMap(curMap, pattern);
                if (curMap.get(pattern) <= map.get(pattern)) {
                    count++;
                } else {
                    while (true) {
                        String str = S.substring(j - count * len, j - count * len + len);
                        curMap.put(str, curMap.get(str) - 1);
                        if (str.equals(pattern)) break;
                        count--;
                    }
                }
                if (count == L.length) {   // find all words
                    ans.add(j - len * (L.length - 1));
                    // move to next word
                    String first = S.substring(j - len * (L.length - 1), j - len * (L.length - 1) + len);
                    curMap.put(first, curMap.get(first) - 1);
                    count--;
                }
            }
        }
        return ans;
    }

    public void updateMap(Map<String, Integer> map, String key) {
        Integer obj = map.get(key);
        if (obj != null) {
            map.put(key, obj + 1);
        } else {
            map.put(key, 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> ans = new SubstringWithConcatenationOfAllWords().findSubstring("abaababbaba",
                new String[]{"ab", "ba", "ab", "ba"});
        for (int x : ans) {
            System.out.println(x);
        }
    }
}
