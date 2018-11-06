/**
 * Created by yaodh on 2018/11/6.
 */
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] A, int S) {
        if (S == 0) return numSubarraysZero(A);
        int[] index = new int[A.length + 2];
        int count = 0;
        index[count++] = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                index[count++] = i;
            }
        }
        index[count++] = A.length;
        int ans = 0;
        for (int i = 1; i < count - S; i++) {
            ans += (index[i] - index[i - 1]) * (index[i + S] - index[i + S - 1]);
        }
        return ans;
    }

    private int numSubarraysZero(int[] A) {
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            while (i < A.length && A[i] == 1) i++;
            int count = 0;
            while (i < A.length && A[i] == 0) {
                count++;
                i++;
            }
            ans += count * (count + 1) / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new BinarySubarraysWithSum().numSubarraysWithSum(new int[]{0, 0, 0, 0, 0, 1, 0, 0}, 0));
    }
}
