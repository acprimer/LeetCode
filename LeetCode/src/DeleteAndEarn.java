/**
 * Created by yaodh on 2017/12/20.
 */
public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int MAX_N = 1024;
        int[] earned = new int[MAX_N];
        for (int n : nums) {
            earned[n] += n;
        }

        int[] f = new int[MAX_N];
        f[1] = earned[1];
        f[2] = earned[2];
        int ans = Math.max(f[1], f[2]);
        for (int i = 3; i < MAX_N; i++) {
            f[i] = Math.max(f[i - 2], f[i - 3]) + earned[i];
            ans = Math.max(ans, f[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{1}));
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{1, 2}));
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{1, 6, 3, 3, 8, 4, 8, 10, 1, 3}));
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{1, 1, 1, 2, 4, 5, 5, 5, 6}));
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{10, 8, 4, 2, 1, 3, 4, 8, 2, 9, 10, 4, 8, 5, 9, 1, 5, 1, 6, 8, 1, 1, 6, 7, 8, 9, 1, 7, 6, 8, 4, 5, 4, 1, 5, 9, 8, 6, 10, 6, 4, 3, 8, 4, 10, 8, 8, 10, 6, 4, 4, 4, 9, 6, 9, 10, 7, 1, 5, 3, 4, 4, 8, 1, 1, 2, 1, 4, 1, 1, 4, 9, 4, 7, 1, 5, 1, 10, 3, 5, 10, 3, 10, 2, 1, 10, 4, 1, 1, 4, 1, 2, 10, 9, 7, 10, 1, 2, 7, 5}));
    }
}
