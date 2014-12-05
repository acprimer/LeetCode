/**
 * Created by yaodh on 2014/11/17.
 *
 * LeetCode: Convert Sorted Array to Binary Search Tree
 * Link: https://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Description:
 * -----------------------------
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * -----------------------------
 *
 * Tag: BST
 */
public class ConvertSortedArrayToBST {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null) return null;
        return build(num, 0, num.length-1);
    }

    private TreeNode build(int[] num, int start, int end) {
        if(start > end) return null;
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = build(num, start, mid-1);
        root.right = build(num, mid+1, end);
        return root;
    }

    public void dfs(TreeNode root) {
        if(root == null) return;
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new ConvertSortedArrayToBST().sortedArrayToBST(new int[]{1,2,3,4,5,6,7});
        new ConvertSortedArrayToBST().dfs(root);
    }
}
