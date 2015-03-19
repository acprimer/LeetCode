/**
 * Created by yaodh on 2015/3/19.
 * LeetCode: Reverse Bits
 * Link: https://leetcode.com/problems/reverse-bits/
 * Description:
 * -----------------------------
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 000000o10100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * -----------------------------
 * <p/>
 * Tag: Bit
 */
public class ReverseBits {
    public int reverseBits(int n) {
        for (int i = 0; i < 16; i++) {
            int j = 31 - i;
            if (((n >> i) & 1) != ((n >> j) & 1)) {
                n ^= (1 << i) | (1 << j);
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int ans = new ReverseBits().reverseBits(43261596);
        System.out.println(ans);
    }
}
