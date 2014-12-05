/**
 * Created by yaodh on 2014/11/28.
 * <p/>
 * LeetCode: Remove Element
 * Link: https://oj.leetcode.com/problems/remove-element/
 * Description:
 * -----------------------------
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * -----------------------------
 * <p/>
 * Tag: TwoPointers
 */
public class RemoveElement {
    public int removeElement(int[] A, int elem) {
        if (A.length <= 0) return 0;
        int i = 0, j = A.length - 1;
        while (i <= j) {
            while (j >= i && A[j] == elem) j--;
            if (j < i) return i;
            if (A[i] == elem) {
                swap(A, i, j);
                j--;
            }
            i++;
        }
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int ans = new RemoveElement().removeElement(new int[]{1, 2, 1}, 1);
        System.out.println(ans);
    }
}
