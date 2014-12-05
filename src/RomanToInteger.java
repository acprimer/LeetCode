/**
 * Created by yaodh on 2014/11/30.
 * <p/>
 * LeetCode: Roman to Integer
 * Link: https://oj.leetcode.com/problems/roman-to-integer/
 * Description:
 * -----------------------------
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * -----------------------------
 * <p/>
 * Tag: Math
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        char[] digits = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] powers = new int[]{1, 10, 100, 1000};
        int i = 0, ans = 0;
        while (i < s.length() && s.charAt(i) == 'M') {
            ans += 1000;
            i++;
        }
        char x, y, z;
        for (int j = 2; j >= 0; j--) {
            x = digits[j * 2];
            y = digits[j * 2 + 1];
            z = digits[j * 2 + 2];
            if (i + 1 < s.length() && s.charAt(i) == x && s.charAt(i + 1) == z) {
                ans += powers[j + 1] - powers[j];
                i += 2;
                continue;
            }
            int tmp = 0;
            if (i < s.length() && s.charAt(i) == y) {
                tmp = 5 * powers[j];
                i++;
            }
            while (i < s.length() && s.charAt(i) == x) {
                tmp += powers[j];
                i++;
            }
            if (i < s.length() && s.charAt(i) == y) {
                tmp = 5 * powers[j] - tmp;
                i++;
            }
            ans += tmp;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new RomanToInteger().romanToInt("MCDLXXVI");
        System.out.println(ans);
    }
}
