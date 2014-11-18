/**
 * Created by yaodh on 2014/11/18.
 *
 * LeetCode: Validate Binary Search Tree
 * Link: https://oj.leetcode.com/problems/validate-binary-search-tree/
 * Description:
 * -----------------------------
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * ---The left subtree of a node contains only nodes with keys less than the node's key.
 * ---The right subtree of a node contains only nodes with keys greater than the node's key.
 * ---Both the left and right subtrees must also be binary search trees.
 * -----------------------------
 *
 * Tag: DFS
 */
public class ValidateBinarySearchTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int maxVal, minVal;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        int leftMin = root.val;
        if(root.left != null) {
            if(dfs(root.left)) {
                if (root.val <= maxVal) {
                    return false;
                }
                leftMin = minVal;
            }
            else {
                return false;
            }
        }
        int rightMax = root.val;
        if(root.right != null) {
            if(dfs(root.right)) {
                if (minVal <= root.val) {
                    return false;
                }
                rightMax = maxVal;
            }
            else {
                return false;
            }
        }
        minVal = leftMin;
        maxVal = rightMax;
        return true;
    }

    public TreeNode generateTree() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(30);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(45);
        root.right = node1;
        node1.left = node2;
        node2.right = node3;
        node3.right = node4;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new ValidateBinarySearchTree().generateTree();
        boolean ans = new ValidateBinarySearchTree().isValidBST(root);
        System.out.println(ans);
    }
}
