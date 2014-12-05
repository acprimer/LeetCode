import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaodh on 2014/11/17.
 *
 * LeetCode: Construct Binary Tree from Inorder and Postorder Traversal
 * Link: https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * Description:
 * -----------------------------
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * You may assume that duplicates do not exist in the tree.
 * -----------------------------
 *
 * Tag: DFS
 */
public class ConstructBinaryTreeFromInorderPostorderTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    Map<Integer, Integer> mapInorder = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++) {
            mapInorder.put(inorder[i], i);
        }
        int size = inorder.length;
        if(size <= 0) return null;
        TreeNode root = new TreeNode(postorder[size-1]);
        return dfs(inorder, postorder, 0, size-1, 0, size-1);
    }
    public TreeNode dfs(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        int val = postorder[postEnd];
        TreeNode root = new TreeNode(val);
        if(inEnd == inStart) return root;
        int idx = mapInorder.get(val);
        if(idx > inStart) {
            root.left = dfs(inorder, postorder, inStart, idx - 1, postStart, idx-1-inStart+postStart);
        }
        if(inEnd > idx) {
            root.right = dfs(inorder, postorder, idx + 1, inEnd, idx-inStart+postStart, postEnd - 1);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new ConstructBinaryTreeFromInorderPostorderTraversal().buildTree(new int[]{2,1,3,5,4,6}, new int[]{2,1,5,6,4,3});
        new ConstructBinaryTreeFromInorderPostorderTraversal().dfsPrintTree(root);
    }

    public void dfsPrintTree(TreeNode root) {
        if(root == null) return;
        System.out.println(root.val);
        dfsPrintTree(root.left);
        dfsPrintTree(root.right);
    }
}
