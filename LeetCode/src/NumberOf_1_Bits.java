/**
 * Created by yaodh on 2015/3/19.
 * LeetCode: Number of 1 Bits
 * Link: https://leetcode.com/problems/number-of-1-bits/
 * Description:
 * -----------------------------
 * Write a function that takes an unsigned integer
 * and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
 * so the function should return 3.
 * -----------------------------
 * <p/>
 * Tag: Bit
 */
public class NumberOf_1_Bits {
    public int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int ans = new NumberOf_1_Bits().hammingWeight(0xffffffff);
        System.out.println(ans);
    }
}
