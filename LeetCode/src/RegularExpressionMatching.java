/**
 * Created by yao on 2014/11/30.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return match(s, p, 0, 0, false);
    }

    private boolean match(String s, String p, int sIndex, int pIndex, boolean flag) {
        if (pIndex >= p.length()) {
            if (!flag && sIndex < s.length()) return false;
            return true;
        }
        for (int i = 0; i + pIndex < p.length(); i++) {
            if (p.charAt(i + pIndex) == '*') {
                for (int j = i - 1; j >= 0; j--) {
                    if (j + sIndex < 0 || j + sIndex >= s.length()
                            || (p.charAt(j + pIndex) != '.' && p.charAt(j + pIndex) != s.charAt(j + sIndex))) {
                        return false;
                    }
                }
                return match(s, p, i + sIndex, i + pIndex + 1, true);
            }
            if (flag) continue;
            if (i + sIndex >= s.length()
                    || (p.charAt(i + pIndex) != '.' && p.charAt(i + pIndex) != s.charAt(i + sIndex))) {
                return false;
            }
        }
        return s.length() == p.length();
    }

    public static void main(String[] args) {
        boolean ans = new RegularExpressionMatching().isMatch("a", ".*..a*");
        System.out.println(ans);
    }
}
