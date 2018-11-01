import java.util.Arrays;

/**
 * Created by yaodh on 2018/11/1.
 */
public class BeautifulArray {
    public int[] beautifulArray(int n) {
        int[] ans = new int[n];
        ans[0] = 1;
        int cnt = 1;
        while (cnt < n) {
            int[] tmp = Arrays.copyOf(ans, cnt);
            cnt = 0;
            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i] * 2 - 1 <= n) {
                    ans[cnt++] = tmp[i] * 2 - 1;
                }
            }
            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i] * 2 <= n) {
                    ans[cnt++] = tmp[i] * 2;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new BeautifulArray().beautifulArray(5)));
    }
}
