/**
 * Created by yaodh on 2014/12/4.
 * Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.
 */
public class TapeEquilibrium {
    public int solution(int[] A) {
        int ans = Integer.MAX_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        int left = 0, right = sum;
        for (int i = 0; i < A.length - 1; i++) {
            left += A[i];
            right -= A[i];
            ans = Math.min(ans, Math.abs(left - right));
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new TapeEquilibrium().solution(new int[]{3, 1, 2, 4, 3});
        System.out.println(ans);
    }
}
