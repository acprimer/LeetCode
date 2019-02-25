import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by yaodh on 2014/11/19.
 * <p>
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
 * <p>
 * Tag: DFS
 */
public class BinaryTreeInorderTraversal {
    // DFS
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        if(root == null) return ans;
//        ans.addAll(inorderTraversal(root.left));
//        ans.add(root.val);
//        ans.addAll(inorderTraversal(root.right));
//        return ans;
//    }

    // non recursive
    // 使用栈来进行中序遍历，需要修改Tree的结构
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            if (p.left == null && p.right == null) {
                ans.add(p.val);
                continue;
            }
            TreeNode left = p.left;
            TreeNode right = p.right;
            p.left = p.right = null;
            if (right != null) stack.push(right);
            stack.push(p);
            if (left != null) stack.push(left);
        }
        return ans;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            ans.add(p.val);
            TreeNode left = p.left;
            TreeNode right = p.right;
            p.left = p.right = null;
            if (right != null) stack.push(right);
            if (left != null) stack.push(left);
        }
        return ans;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            if (p.left == null && p.right == null) {
                ans.add(p.val);
                continue;
            }
            TreeNode left = p.left;
            TreeNode right = p.right;
            p.left = p.right = null;
            stack.push(p);
            if (right != null) stack.push(right);
            if (left != null) stack.push(left);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);

        System.out.println(Arrays.toString(new BinaryTreeInorderTraversal().postorderTraversal(tree).toArray()));
    }
}
