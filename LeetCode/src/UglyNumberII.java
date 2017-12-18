/**
 * Created by yaodh on 2017/12/18.
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[1695];
        int[] idx = {1, 1, 1};
        ugly[1] = 1;
        for (int i = 2; i <= n; i++) {
            int x1 = ugly[idx[0]] * 2;
            int x2 = ugly[idx[1]] * 3;
            int x3 = ugly[idx[2]] * 5;
            int min = Math.min(Math.min(x1, x2), x3);
            ugly[i] = min;
            if (x1 == min) {
                idx[0]++;
            }
            if (x2 == min) {
                idx[1]++;
            }
            if (x3 == min) {
                idx[2]++;
            }
        }
        return ugly[n];
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumberII().nthUglyNumber(12));
    }
}
