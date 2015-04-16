/**
 * Created by yaodh on 2015/4/16.
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
