/**
 * Created by yaodh on 2014/11/17.
 *
 * LeetCode: Balanced Binary Tree
 * Link: https://oj.leetcode.com/problems/balanced-binary-tree/
 * Description:
 * -----------------------------
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * -----------------------------
 *
 * Tag: DFS
 */
public class BalancedBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int leftHeight, rightHeight;
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        dfs(root);
        if(Math.abs(leftHeight-rightHeight) > 1) {
            ans = false;
        }
        return ans;
    }

    private void dfs(TreeNode root) {
        if(root.left == null && root.right == null) {
            leftHeight = rightHeight = 1;
            return;
        }
        int leftLeftHeight = 0, leftRightHeight = 0;
        if(root.left != null) {
            dfs(root.left);
            if(Math.abs(leftHeight-rightHeight) > 1) {
                ans = false;
                return;
            }
            leftLeftHeight = leftHeight;
            leftRightHeight = rightHeight;
        }
        int rightLeftHeight = 0, rightRightHeight = 0;
        if(root.right != null) {
            dfs(root.right);
            if(Math.abs(leftHeight-rightHeight) > 1) {
                ans = false;
                return;
            }
            rightLeftHeight = leftHeight;
            rightRightHeight = rightHeight;
        }
        leftHeight = Math.max(leftLeftHeight, leftRightHeight) + 1;
        rightHeight = Math.max(rightLeftHeight, rightRightHeight) + 1;
    }

    public TreeNode generateTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        node5.right = node6;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new BalancedBinaryTree().generateTree();
        boolean ans = new BalancedBinaryTree().isBalanced(root);
        System.out.println(ans);
    }
}
