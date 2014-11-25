/**
 * Created by yaodh on 2014/11/25.
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        if (A.length <= 1) return 0;
        int preMax = A[0];
        int ans = 0;
        for (int i = 1; i < A.length; i++) {
            while (i < A.length && A[i] >= A[i - 1]) {
                preMax = A[i];
                i++;
            }
            int j = i;
            while (j < A.length && A[j] <= A[j - 1]) {
                ans += preMax - A[j];
                j++;
            }
            while (j < A.length && A[j] >= A[j - 1] && A[j] <= preMax) {
                ans += preMax - A[j];
                j++;
            }
            if (A[j - 1] < preMax) {
                ans -= (j - i) * (preMax - A[j - 1]);
                preMax = A[j - 1];
            }
            i = j - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(ans);
    }
}
