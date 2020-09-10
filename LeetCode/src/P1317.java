import java.util.Arrays;

public class P1317 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P1317().getNoZeroIntegers(19)));
        System.out.println(Arrays.toString(new P1317().getNoZeroIntegers(2)));
        System.out.println(Arrays.toString(new P1317().getNoZeroIntegers(11)));
        System.out.println(Arrays.toString(new P1317().getNoZeroIntegers(111)));
        System.out.println(Arrays.toString(new P1317().getNoZeroIntegers(10000)));
        System.out.println(Arrays.toString(new P1317().getNoZeroIntegers(1010)));
        System.out.println(Arrays.toString(new P1317().getNoZeroIntegers(111100)));
        System.out.println(Arrays.toString(new P1317().getNoZeroIntegers(111000)));
        System.out.println(Arrays.toString(new P1317().getNoZeroIntegers(1111111)));
    }

    /*public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i <= n / 2; i++) {
            if (check(i) && check(n - i)) {
                return new int[]{i, n - i};
            }
        }
        return new int[]{-1, -1};
    }

    private boolean check(int x) {
        if (x == 0) return false;
        while (x != 0) {
            if (x % 10 == 0) return false;
            x /= 10;
        }
        return true;
    }*/

    public int[] getNoZeroIntegers(int n) {
        int x = 0;
        int carry = 0;
        int tempN = n;
        int pow = 1;
        while (n != 0) {
            if (carry == 1) {
                n -= carry;
                carry = 0;
                continue;
            }
            int w = n % 10;
            if (w == 0 || w == 1) {
                carry = 1;
                if (x + pow *(w+1) < tempN) {
                    x += pow * (w + 1);
                }
            } else {
                carry = 0;
                x += pow;
            }
            n /= 10;
            pow *= 10;
        }
        return new int[]{x, tempN - x};
    }
}
