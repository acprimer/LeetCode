import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaodh on 2014/11/17.
 *
 * LeetCode: Construct Binary Tree from Preorder and Inorder Traversal
 * Link: https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Description:
 * -----------------------------
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * You may assume that duplicates do not exist in the tree.
 * -----------------------------
 *
 * Tag: DFS
 */
public class ConstructBinaryTreeFromPreorderInorderTraversal {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    Map<Integer, Integer> mapInorder = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++) {
            mapInorder.put(inorder[i], i);
        }
        int size = inorder.length;
        if(size <= 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        return dfs(inorder, preorder, 0, size-1, 0, size-1);
    }
    public TreeNode dfs(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd) {
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        if(inEnd == inStart) return root;
        int idx = mapInorder.get(val);
        if(idx > inStart) {
            root.left = dfs(inorder, preorder, inStart, idx - 1, preStart+1, idx-inStart+preStart);
        }
        if(inEnd > idx) {
            root.right = dfs(inorder, preorder, idx + 1, inEnd, idx-inStart+preStart+1, preEnd);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new ConstructBinaryTreeFromPreorderInorderTraversal().buildTree(new int[]{3,1,2,4,5,6}, new int[]{2,1,3,5,4,6});
        new ConstructBinaryTreeFromPreorderInorderTraversal().dfsPrintTree(root);
    }

    public void dfsPrintTree(TreeNode root) {
        if(root == null) return;
        System.out.println(root.val);
        dfsPrintTree(root.left);
        dfsPrintTree(root.right);
    }
}
