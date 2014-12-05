/**
 * Created by yaodh on 2014/11/19.
 *
 * LeetCode: Unique Binary Search Trees
 * Link: https://oj.leetcode.com/problems/unique-binary-search-trees/
 * Description:
 * -----------------------------
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, there are a total of 5 unique BST's.
 * -----------------------------
 *
 * Tag: Math
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] f = new int[n+1];
        f[0] = f[1] = 1;
        for(int i=2;i<=n;i++) {
            for(int j=0;j<i;j++) {
               f[i] += f[j] * f[i-j-1];
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        int ans = new UniqueBinarySearchTrees().numTrees(4);
        System.out.println(ans);
    }
}
