/**
 * Created by yaodh on 2014/12/20.
 * <p/>
 * LeetCode: Excel Sheet Column Title
 * Link: https://oj.leetcode.com/problems/excel-sheet-column-title/
 * Description:
 * -----------------------------
 * Given a non-zero positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * -----------------------------
 * <p/>
 * Tag: Math
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            n--;
            builder.append((char) (n % 26 + 'A'));
            n /= 26;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        String ans = new ExcelSheetColumnTitle().convertToTitle(29);
        System.out.println(ans);
    }
}
