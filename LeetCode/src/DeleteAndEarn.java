/**
 * Created by yaodh on 2017/12/20.
 */
public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int[] cnt = new int[1024];
        int max = 0;
        for (int n : nums) {
            cnt[n]++;
            if (n > max) max = n;
        }
        int sum = 0;
        for (int i = 1; i <= max; i++) {
            while (cnt[i] == 0) i++;
            int odd = 0, even = 0;
            while (cnt[i] > 0) {
                cnt[i] *= i;
                if (i % 2 == 1) odd += cnt[i];
                else even += cnt[i];
                i++;
            }
            sum += Math.max(odd, even);
        }

        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{3, 4, 2}));
//        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
//        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{1,6,3,3,8,4,8,10,1,3}));
//        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{1,1,1,2,4,5,5,5,6}));
        System.out.println(new DeleteAndEarn().deleteAndEarn(new int[]{10,8,4,2,1,3,4,8,2,9,10,4,8,5,9,1,5,1,6,8,1,1,6,7,8,9,1,7,6,8,4,5,4,1,5,9,8,6,10,6,4,3,8,4,10,8,8,10,6,4,4,4,9,6,9,10,7,1,5,3,4,4,8,1,1,2,1,4,1,1,4,9,4,7,1,5,1,10,3,5,10,3,10,2,1,10,4,1,1,4,1,2,10,9,7,10,1,2,7,5}));
    }
}
