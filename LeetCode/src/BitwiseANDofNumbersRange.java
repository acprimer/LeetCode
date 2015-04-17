/**
 * Created by yaodh on 2015/4/16.
 * <p/>
 * LeetCode: Bitwise AND of Numbers Range
 * Link: https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * Description:
 * -----------------------------
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 * -----------------------------
 * Tag: Bit
 */
public class BitwiseANDofNumbersRange {
    public int getBit(int x) {
        int ans = 0;
        while (x != 0) {
            x >>= 1;
            ans++;
        }
        return ans;
    }

    public int rangeBitwiseAnd(int m, int n) {
        int mBit = getBit(m);
        int nBit = getBit(n);
        int ans = 0;
        for (int i = Math.max(mBit, nBit) - 1; i >= 0; i--) {
            if ((m & (1 << i)) == (n & (1 << i))) {
                ans |= (n & (1 << i));
            } else {
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new BitwiseANDofNumbersRange().rangeBitwiseAnd(5, 5);
        System.out.println(ans);
    }
}
