import java.util.ArrayList;
import java.util.List;
/**
 * Created by yaodh on 2014/11/19.
 *
 * LeetCode: Binary Tree Inorder Traversal
 * Link: https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 * Description:
 * -----------------------------
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [1,3,2].
 * -----------------------------
 *
 * Tag: DFS
 */
public class BinaryTreeInorderTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    List<Integer> ans = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return ans;
        dfs(root);
        return ans;
    }

    private void dfs(TreeNode root) {
        if(root.left != null) dfs(root.left);
        ans.add(root.val);
        if(root.right != null) dfs(root.right);
    }
}
