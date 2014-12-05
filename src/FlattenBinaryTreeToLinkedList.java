/**
 * Created by yaodh on 2014/11/17.
 *
 * LeetCode: Flatten Binary Tree to Linked List
 * Link: https://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * Description:
 * -----------------------------
 * Given a binary tree, flatten it to a linked list in-place.
 * For example,
 * Given
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 * \
 *  2
 *   \
 *    3
 *     \
 *      4
 *       \
 *        5
 *         \
 *          6
 * -----------------------------
 *
 * Tag: DFS
 */
public class FlattenBinaryTreeToLinkedList {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    TreeNode first, last;
    public void flatten(TreeNode root) {
        if(root == null) return;
        dfs(root);
    }

    public void dfs(TreeNode root) {
        if(root.left == null && root.right == null) {
            first = last = root;
            return;
        }
        TreeNode rightLast = null;
        if(root.right != null) {
            flatten(root.right);
            rightLast = last;
        }
        if(root.left != null) {
            flatten(root.left);
            last.right = root.right;
            root.right = first;
            root.left = null;
            if(rightLast != null) {
                last = rightLast;
            }
        }
        first = root;
    }

    public TreeNode generateTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new FlattenBinaryTreeToLinkedList().generateTree();
        new FlattenBinaryTreeToLinkedList().flatten(root);
        System.out.println(root.left);
        while(root != null) {
            System.out.println(root.val);
            root = root.right;
        }
    }
}
