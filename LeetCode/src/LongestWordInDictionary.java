import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yaodh on 2017/12/18.
 */
public class LongestWordInDictionary {

    class Trie {
        char letter;
        boolean flag;
        Trie[] next = new Trie[26];

        public Trie(char letter) {
            this.letter = letter;
        }
    }

    private void dfs(Trie head, int len, String word) {
        if (head == null || !head.flag) return;
        len++;
        word += head.letter;
        if (len > maxLength) {
            maxLength = len;
            ans = word;
        }
        for (int i = 0; i < 26; i++) {
            dfs(head.next[i], len, word);
        }
    }

    private int maxLength = 0;
    private String ans = "";
    public String longestWord(String[] words) {
        Trie head = new Trie(' ');
        head.flag = true;
        for (String s : words) {
            Trie p = head;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (p.next[ch - 'a'] == null) {
                    p.next[ch - 'a'] = new Trie(ch);
                }
                p = p.next[ch - 'a'];
            }
            p.flag = true;
        }
        dfs(head, 0, "");
        return ans.substring(1);
    }

    // hashset
//    public String longestWord(String[] words) {
//        Set<String> set = new HashSet<>(Arrays.asList(words));
//        String longest = "";
//        int maxLength = 0;
//        for (String s : words) {
//            if (s.length() < maxLength) continue;
//            boolean flag = true;
//            for (int i = 1; i < s.length(); i++) {
//                if (!set.contains(s.substring(0, i))) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (!flag) continue;
//            if (s.length() > maxLength || s.compareTo(longest) < 0) {
//                maxLength = s.length();
//                longest = s;
//            }
//        }
//        return longest;
//    }

    public static void main(String[] args) {
        System.out.println(new LongestWordInDictionary()
                .longestWord(new String[]{""}));
    }
}
