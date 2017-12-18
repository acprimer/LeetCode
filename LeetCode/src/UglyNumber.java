/**
 * Created by yaodh on 2017/12/18.
 */
public class UglyNumber {
    public boolean isUgly(int num) {
        if (num == 0) return false;

        for (int p : new int[]{2, 3, 5}) {
            while (num % p == 0) num /= p;
        }
        return num == 1;
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber().isUgly(0));
    }
}
