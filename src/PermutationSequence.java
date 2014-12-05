/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Permutation Sequence
 * Link: https://oj.leetcode.com/problems/permutation-sequence/
 * Description:
 * -----------------------------
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 * -----------------------------
 * <p/>
 * Tag: Math
 */
public class PermutationSequence {
    // method 2: generate the kth permutation
    public String getPermutation(int n, int k) {
        int[] num = new int[n];
        for (int i = 0; i < n; i++) num[i] = i + 1;
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        k--;
        int idx;
        for (idx = 1; idx <= n; idx++) {
            factorial[idx] = factorial[idx - 1] * idx;
            if (factorial[idx] >= k) break;
        }
        while (k > 0) {
            while (k < factorial[idx]) idx--;
            int count = k / factorial[idx];
            int tmp = num[n - 1 - idx + count];
            for (int i = n - 1 - idx + count; i > n - 1 - idx; i--) {
                num[i] = num[i - 1];
            }
            num[n - idx - 1] = tmp;
            k %= factorial[idx];
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(num[i]);
        }
        return builder.toString();
    }

    // method 1: generate all permutations from 1 to k
    /*public String getPermutation(int n, int k) {
        int[] num = new int[n];
        for(int i=0;i<n;i++) num[i] = i+1;
        while(--k>0) {
            nextPermutation(num);
        }
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<n;i++) {
            builder.append(num[i]);
        }
        return builder.toString();
    }
    public void nextPermutation(int[] num) {
        if(num.length<=1) return;
        for(int i=num.length-2;i>=0;i--) {
            if(num[i] < num[i+1]) {
                int idx = reverse(num, i+1, num[i]);
                swap(num, i, idx);
                return;
            }
        }
        reverse(num, 0, 0);
    }

    private int reverse(int[] num, int start, int target) {
        for(int i=start,j=num.length-1;i<j;i++,j--) {
            swap(num, i, j);
        }
        for(int i=start;i<num.length;i++) {
            if(num[i] > target) return i;
        }
        return -1;
    }

    public void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }*/

    public static void main(String[] args) {
        String ans = new PermutationSequence().getPermutation(3, 3);
        System.out.println(ans);
    }
}
