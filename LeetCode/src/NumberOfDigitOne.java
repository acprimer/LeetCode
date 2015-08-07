/**
 * Created by yaodh on 2015/8/5.
 */
public class NumberOfDigitOne {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        int remain = 0;
        int power = 1;
        while (n != 0) {
            int digit = n % 10;
            count += power * (n / 10 + (digit > 1 ? 1 : 0));
            if (digit == 1) {
                count += remain + 1;
            }
            remain += power * digit;
            n /= 10;
            power *= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfDigitOne().countDigitOne(13));
    }
}
