/**
 * Created by yaodh on 2018/11/2.
 */
public class SuperPow {
    private static final int MOD = 1337;

    public int superPow(int a, int[] b) {
        if (a == 1) return 1;
        int ans = 1;
        for (int i = b.length - 1; i >= 0; i--) {
            ans = (ans * pow(a, b[i])) % MOD;
            a = pow(a, 10);
        }
        return ans;
    }

    private int pow(long x, int k) {
        long ans = 1;
        while (k != 0) {
            if ((k & 1) == 1) ans = (ans * x) % MOD;
            x = (x * x) % MOD;
            k >>= 1;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(new SuperPow().pow(2147483647, 2));
        System.out.println(new SuperPow().superPow(2147483647, new int[]{2, 0, 0}));
    }
}
