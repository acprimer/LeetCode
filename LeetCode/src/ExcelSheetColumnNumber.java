/**
 * Created by yaodh on 2014/12/28.
 * <p/>
 * LeetCode: Excel Sheet Column Number
 * Link: https://oj.leetcode.com/problems/excel-sheet-column-number/
 * Description:
 * -----------------------------
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * -----------------------------
 * <p/>
 * Tag: Array
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans = ans * 26 + s.charAt(i) - 'A' + 1;
        }
        return ans;
    }
}
