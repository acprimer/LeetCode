/**
 * Created by yaodh on 2014/11/22.
 * <p/>
 * LeetCode: Sort Colors
 * Link: https://oj.leetcode.com/problems/sort-colors/
 * Description:
 * -----------------------------
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * -----------------------------
 * <p/>
 * Tag: Hash
 */
public class SortColors {
    public void sortColors(int[] A) {
        int[] idx = new int[4];
        int[] count = new int[3];
        for (int i = 0; i < A.length; i++) {
            int tmp = A[i];
            for (int j = tmp + 1; j < 3; j++) {
                if (idx[j + 1] > idx[j]) {
                    A[idx[j]] = tmp;
                    A[i] = j;
                }
            }
            count[tmp]++;
            idx[1] = count[0];
            idx[2] = idx[1] + count[1];
            idx[3] = i + 1;
        }
    }
    /*public void sortColors(int[] A) {
        int[] colors = new int[3];
        for (int i = 0; i < A.length; i++) {
            colors[A[i]]++;
        }
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < colors[i]; j++) {
                A[idx++] = i;
            }
        }
    }*/

    public static void main(String[] args) {
        int[] A = new int[]{2, 0, 2, 1, 0, 2, 2, 0, 1, 2};
        new SortColors().sortColors(A);
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }
}
