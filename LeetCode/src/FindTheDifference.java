/**
 * Created by yaodh on 2017/12/18.
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDifference().findTheDifference("abecd", "abcdee"));
    }
}
