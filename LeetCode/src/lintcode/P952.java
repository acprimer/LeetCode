package lintcode;

public class P952 {
    public int digitConvert(int n) {
        int ans = 0;
        while (n != 1) {
            if ((n & 1) != 0) {
                n = 3 * n + 1;
            } else {
                n /= 2;
            }
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P952().digitConvert(3));
    }
}
