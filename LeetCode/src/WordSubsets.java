import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2018/11/1.
 */
public class WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] cnt = new int[26];
        for (String s : B) {
            int[] t = countLetter(s);
            for (int i = 0; i < 26; i++) {
                if (t[i] > cnt[i]) cnt[i] = t[i];
            }
        }
        List<String> ans = new ArrayList<>();
        for (String s : A) {
            int[] t = countLetter(s);
            int i = 0;
            while (i < 26) {
                if (t[i] < cnt[i]) break;
                i++;
            }
            if (i >= 26) ans.add(s);
        }
        return ans;
    }

    private int[] countLetter(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        List<String> ans = new WordSubsets().wordSubsets(
                new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
                new String[]{"ec", "oc", "ceo"});
        for (String s : ans) {
            System.out.println(s);
        }
    }
}
