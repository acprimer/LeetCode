import java.util.Arrays;

/**
 * Created by yaodh on 2018/10/14.
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        for (int i = 0, j = 1; i < A.length; i += 2, j += 2) {
            while (i < A.length && A[i] % 2 == 0) i += 2;
            while (j < A.length && A[j] % 2 == 1) j += 2;
            if (i >= A.length) break;
            swap(A, i, j);
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortArrayByParityII().sortArrayByParityII(new int[]{4,2,5,7})));
    }
}
