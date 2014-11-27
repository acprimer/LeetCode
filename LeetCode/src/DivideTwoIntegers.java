/**
 * Created by yaodh on 2014/11/27.
 * <p/>
 * LeetCode: Divide Two Integers
 * Link: https://oj.leetcode.com/problems/valid-sudoku/
 * Description:
 * -----------------------------
 * Divide two integers without using multiplication, division and mod operator.
 * -----------------------------
 * <p/>
 * Tag: Binary
 */
public class DivideTwoIntegers {
    // 全部处理成负数
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        int flag = (dividend > 0 ? 1 : -1) * (divisor > 0 ? 1 : -1);
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;
        int ans = 0, count = 1;
        int[] duplicates = new int[32];
        duplicates[0] = divisor;
        for (int i = 1; i < 32; i++) {
            if (dividend - duplicates[i - 1] > duplicates[i - 1]) break;
            duplicates[i] = duplicates[i - 1] + duplicates[i - 1];
            count++;
        }
        count--;
        while (dividend <= divisor) {
            while (count >= 0 && duplicates[count] < dividend) count--;
            dividend -= duplicates[count];
            ans += (1 << count);
        }
        return flag * ans;
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(-2147483646, -2147483647));
    }
}
