/**
 * Created by yaodh on 2014/11/18.
 *
 * LeetCode: Recover Binary Search Tree
 * Link: https://oj.leetcode.com/problems/recover-binary-search-tree/
 * Description:
 * -----------------------------
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * -----------------------------
 *
 * Tag: DFS
 */
public class RecoverBinarySearchTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    TreeNode pre = null, node1 = null, node2 = null;
    public void recoverTree(TreeNode root) {
        if(root == null) return ;
        dfs(root);
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }

    private void dfs(TreeNode root) {
        if(root.left != null) dfs(root.left);
        if(pre == null) {
            pre = root;
        }
        else {
            if(root.val > pre.val) {
                pre = root;
            }
            else {
                if(node1 == null) {
                    node1 = pre;
                    node2 = root;
                }
                else node2 = root;
            }
        }
        if(root.right != null) dfs(root.right);
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
        TreeNode root = new RecoverBinarySearchTree().generateTree();
        new RecoverBinarySearchTree().recoverTree(root);
        dfsPrintTree(root);
    }

    public static void dfsPrintTree(TreeNode root) {
        if(root == null) return;
        System.out.println(root.val);
        dfsPrintTree(root.left);
        dfsPrintTree(root.right);
    }
}
