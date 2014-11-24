/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Next Permutation
 * Link: https://oj.leetcode.com/problems/next-permutation/
 * Description:
 * -----------------------------
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * -----------------------------
 * <p/>
 * Tag: Math
 */
public class NextPermutation {
    public void nextPermutation(int[] num) {
        if (num.length <= 1) return;
        for (int i = num.length - 2; i >= 0; i--) {
            if (num[i] < num[i + 1]) {
                int idx = reverse(num, i + 1, num[i]);
                swap(num, i, idx);
                return;
            }
        }
        reverse(num, 0, 0);
    }

    private int reverse(int[] num, int start, int target) {
        for (int i = start, j = num.length - 1; i < j; i++, j--) {
            swap(num, i, j);
        }
        for (int i = start; i < num.length; i++) {
            if (num[i] > target) return i;
        }
        return -1;
    }

    public void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 1, 4, 1};
        new NextPermutation().nextPermutation(num);
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
    }
}
