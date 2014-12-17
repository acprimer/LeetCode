import java.util.*;

/**
 * Created by yaodh on 2014/12/17.
 * <p/>
 * LeetCode: Fraction to Recurring Decimal
 * Link: https://oj.leetcode.com/problems/fraction-to-recurring-decimal/
 * Description:
 * -----------------------------
 * Given two integers representing the numerator and denominator of a fraction,
 * return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * -----------------------------
 * <p/>
 * Tag: Hash
 */
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        StringBuilder builder = new StringBuilder();
        if ((numerator < 0 && denominator > 0)
                || (numerator > 0 && denominator < 0)) {
            builder.append("-");
        }
        long x = Math.abs((long) numerator);
        long y = Math.abs((long) denominator);
        builder.append(x / y);
        x %= y;
        StringBuilder fraction = new StringBuilder();
        int idx = 0, start = -1;
        while (x != 0) {
            if (map.get(x) != null) {
                start = map.get(x);
                break;
            } else {
                map.put(x, idx);
            }
            x *= 10;
            fraction.append(x / y);
            x %= y;
            idx++;
        }
        if (fraction.length() <= 0) {
            return builder.toString();
        } else if (start == -1) {
            builder.append(".");
            builder.append(fraction);
        } else {
            builder.append(".");
            builder.append(fraction.subSequence(0, start));
            builder.append("(");
            builder.append(fraction.substring(start));
            builder.append(")");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String ans = new FractionToRecurringDecimal().fractionToDecimal(-1, -2147483648);
        System.out.println(ans);
    }
}
