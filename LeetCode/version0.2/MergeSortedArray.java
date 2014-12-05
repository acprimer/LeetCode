/**
 * Created by yaodh on 2014/11/20.
 *
 * LeetCode: Merge Sorted Array
 * Link: https://oj.leetcode.com/problems/merge-sorted-array/
 * Description:
 * -----------------------------
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * You may assume that A has enough space (size that is greater or equal to m + n)
 * to hold additional elements from B. The number of elements initialized in A and B are m
 * and n respectively.
 * -----------------------------
 *
 * Tag: Two Pointers
 */
public class MergeSortedArray {
    public void merge(int A[], int m, int B[], int n) {
        int i = 0, j = 0, k = 0;
        int[] C = new int[m + n];
        while (i < m && j < n) {
            if (A[i] < B[j]) C[k++] = A[i++];
            else C[k++] = B[j++];
        }
        while (i < m) {
            C[k++] = A[i++];
        }
        while (j < n) {
            C[k++] = B[j++];
        }
        for (i = 0; i < m + n; i++) {
            A[i] = C[i];
        }
    }

    public static void main(String[] args) {
        int[] A = new int[3];
        A[0] = 1;
        A[1] = 5;
        A[2] = 6;
        int[] B = new int[]{1,2,3};
        new MergeSortedArray().merge(A, 3, B, 3);
        for (int i = 0; i < 6; i++) {
            System.out.println(A[i]);
        }
    }
}
