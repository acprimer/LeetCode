/**
 * Created by yaodh on 2014/11/27.
 * <p/>
 * LeetCode: ZigZag Conversion
 * Link: https://oj.leetcode.com/problems/zigzag-conversion/
 * Description:
 * -----------------------------
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * -----------------------------
 * <p/>
 * Tag: String
 */
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if (nRows == 1 || nRows >= s.length()) return s;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < s.length(); j += 2 * (nRows - 1)) {
                builder.append(s.charAt(j));
                if (i > 0 && i < nRows - 1 && j + 2 * (nRows - 1 - i) < s.length()) {
                    builder.append(s.charAt(j + 2 * (nRows - 1 - i)));
                }
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String ans = new ZigZagConversion().convert("PAYPALISHIRING", 10);
        System.out.println(ans);
    }
}
