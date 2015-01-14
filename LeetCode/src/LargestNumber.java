import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by yaodh on 2015/1/14.
 * <p/>
 * LeetCode: Largest Number
 * Link: https://oj.leetcode.com/problems/largest-number/
 * Description:
 * -----------------------------
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * -----------------------------
 * <p/>
 * Tag: Sort
 */
public class LargestNumber {
    public String largestNumber(int[] num) {
        String[] numString = new String[num.length];
        for (int i = 0; i < num.length; i++) {
            numString[i] = String.valueOf(num[i]);
        }
        Arrays.sort(numString, new Comparator<String>() {
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
        StringBuilder builder = new StringBuilder();
        for (String str : numString) {
            builder.append(str);
        }
        while (builder.length() > 1 && builder.charAt(0) == '0') {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int[] a = new int[]{0, 0, 0, 0, 1};
        System.out.println(new LargestNumber().largestNumber(a));
    }
}
