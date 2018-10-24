import java.util.Arrays;

/**
 * Created by yaodh on 2018/10/14.
 */
public class ThreeSumWithMultiplicity {
    public static final int MOD = 1000000007;
    public int threeSumMulti(int[] A, int target) {
        Arrays.sort(A);
        int ans = 0;
        for (int i = 0; i < A.length && A[i] <= target; i++) {
            // to find target: target - A[i]
            int j = i + 1;
            int k = A.length - 1;
            while (j < k) {
                int sum = A[i] + A[j] + A[k];
                if (sum == target) {
                    // find
                    if (A[j] == A[k]) {
                        ans = (ans + count(k - j + 1)) % MOD;
                        break;
                    }
                    int left = 1;
                    while (++j < k && A[j] == A[j-1]) left++;
                    int right = 1;
                    while (--k >= j && A[k] == A[k+1]) right++;
                    ans = (ans + left * right) % MOD;
                } else if (sum > target){
                    k--;
                } else {
                    j++;
                }
            }
        }
        return ans;
    }

    private int count(int m) {
        return m * (m-1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumWithMultiplicity().threeSumMulti(new int[]{0, 0, 0}, 0));
        System.out.println(new ThreeSumWithMultiplicity().threeSumMulti(new int[]{1,1,2,2,2,2}, 5));
        System.out.println(new ThreeSumWithMultiplicity().threeSumMulti(new int[]{1,1,2,2,3,3,4,4,5,5}, 8));
    }
}
