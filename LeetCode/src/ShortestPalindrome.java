/**
 * Created by yaodh on 2015/8/1.
 */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if(isPalindrome(s.substring(0, i + 1))) {
                StringBuilder builder = new StringBuilder(s);
                return builder.reverse().substring(0, s.length() - i - 1) + s;
            }
        }
        return null;
    }

    private boolean isPalindrome(String s) {
        for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
