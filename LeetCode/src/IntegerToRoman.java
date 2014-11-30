/**
 * Created by yaodh on 2014/11/30.
 * <p/>
 * LeetCode: Integer to Roman
 * Link: https://oj.leetcode.com/problems/integer-to-roman/
 * Description:
 * -----------------------------
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * -----------------------------
 * <p/>
 * Tag: Math
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        String[][] digits = new String[][]{{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, // 个位
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},   // 十位
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},   // 百位
                {"", "M", "MM", "MMM"}};    //千位
        int[] powers = new int[]{1, 10, 100, 1000};
        StringBuilder builder = new StringBuilder();
        for (int i = 3; i >= 0; i--) {
            builder.append(digits[i][num / powers[i]]);
            num -= num / powers[i] * powers[i];
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String ans = new IntegerToRoman().intToRoman(999);
        System.out.println(ans);
    }
}
