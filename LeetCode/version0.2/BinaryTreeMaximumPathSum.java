/**
 * Created by yaodh on 2014/11/16.
 *
 * LeetCode: Binary Tree Maximum Path Sum
 * Link: https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 * Description:
 * -----------------------------
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example:
 * Given the below binary tree,
 *     1
 *    / \
 *   2   3
 * Return 6.
 * -----------------------------
 *
 * Tag: DFS
 */

public class BinaryTreeMaximumPathSum {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if(root.left == null && root.right == null) {
            ans = Math.max(ans, root.val);
            return root.val;
        }
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        if(root.left != null) {
            leftMax = dfs(root.left);
        }
        if(root.right != null) {
            rightMax = dfs(root.right);
        }
        int rootMax = Integer.MIN_VALUE;
        if(root.left != null && root.right != null) {
            rootMax = leftMax + rightMax + root.val;
        }
        int maxRoot = Math.max(0, Math.max(leftMax, rightMax)) + root.val;
        ans = Math.max(ans, Math.max(maxRoot, rootMax));
        return maxRoot;
    }

    public TreeNode generateTree() {
        TreeNode root = new TreeNode(-2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
//        root.right = node2;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new BinaryTreeMaximumPathSum().generateTree();
        int ans = new BinaryTreeMaximumPathSum().maxPathSum(root);
        System.out.print(ans);
    }
}
