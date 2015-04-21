import java.util.*;

/**
 * Created by yaodh on 2014/11/24.
 * <p/>
 * LeetCode: Anagrams
 * Link: https://oj.leetcode.com/problems/anagrams/
 * Description:
 * -----------------------------
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 * -----------------------------
 * <p/>
 * Tag: Hash
 */
public class Anagrams {
//    public List<String> anagrams(String[] strs) {
//        boolean[] vis = new boolean[strs.length];
//        int[] hashCode = new int[strs.length];
//        List<String> ans = new ArrayList<String>();
//        for (int i = 0; i < strs.length; i++) {
//            hashCode[i] = hashFunction(strs[i]);
//        }
//        for (int i = 0; i < strs.length; i++) {
//            for (int j = i + 1; j < strs.length; j++) {
//                if (hashCode[i] == hashCode[j]) {
//                    if (testAnagram(strs[i], strs[j])) {
//                        if (!vis[i]) ans.add(strs[i]);
//                        if (!vis[j]) ans.add(strs[j]);
//                        vis[i] = vis[j] = true;
//                    }
//                }
//            }
//        }
//        return ans;
//    }
//
//    private boolean testAnagram(String a, String b) {
//        if (a.length() != b.length()) return false;
//        int[] hash = new int[26];
//        for (int i = 0; i < a.length(); i++) {
//            hash[a.charAt(i) - 'a']++;
//            hash[b.charAt(i) - 'a']--;
//        }
//        for (int i = 0; i < 26; i++) {
//            if (hash[i] != 0) return false;
//        }
//        return true;
//    }
//
//    private int hashFunction(String str) {
//        int ans = 0;
//        for (int i = 0; i < str.length(); i++) {
//            ans |= (1 << str.charAt(i) - 'a');
//        }
//        return ans;
//    }

    public List<String> anagrams(String[] strs) {
        boolean[] flag = new boolean[strs.length];
        List<String> ans = new ArrayList<String>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            String t = Arrays.toString(chs);
            if(map.containsKey(t)) {
                map.get(t).add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(t, list);
            }
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            if(entry.getValue().size() > 1) {
                ans.addAll(entry.getValue());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<String> ans = new Anagrams().anagrams(new String[]{"aba", "aba", "aab", "ab", "ba", "c"});
        for (String str : ans) {
            System.out.println(str);
        }
    }
}
