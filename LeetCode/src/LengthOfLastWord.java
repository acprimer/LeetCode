/**
 * Created by yao on 2014/11/23.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.equals("")) return 0;
        int p = 0, q = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            p = q = i;
            while (q < s.length() && s.charAt(q) != ' ') q++;
            i = --q;
        }
        return q - p + 1;
    }

    public static void main(String[] args) {
        int ans = new LengthOfLastWord().lengthOfLastWord(" ");
        System.out.println(ans);
    }
}
