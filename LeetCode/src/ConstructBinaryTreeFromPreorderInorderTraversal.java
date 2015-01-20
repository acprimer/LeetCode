import java.util.HashMap;
import java.util.Map;

/**
 * Created by yaodh on 2014/11/17.
 * <p/>
 * LeetCode: Construct Binary Tree from Preorder and Inorder Traversal
 * Link: https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Description:
 * -----------------------------
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * You may assume that duplicates do not exist in the tree.
 * -----------------------------
 * <p/>
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

//    Map<Integer, Integer> mapInorder = new HashMap<Integer, Integer>();
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        for (int i = 0; i < inorder.length; i++) {
//            mapInorder.put(inorder[i], i);
//        }
//        int size = inorder.length;
//        if (size <= 0) return null;
//        TreeNode root = new TreeNode(preorder[0]);
//        return dfs(inorder, preorder, 0, size - 1, 0, size - 1);
//    }
//
//    public TreeNode dfs(int[] inorder, int[] preorder, int inStart, int inEnd, int preStart, int preEnd) {
//        int val = preorder[preStart];
//        TreeNode root = new TreeNode(val);
//        if (inEnd == inStart) return root;
//        int idx = mapInorder.get(val);
//        if (idx > inStart) {
//            root.left = dfs(inorder, preorder, inStart, idx - 1, preStart + 1, idx - inStart + preStart);
//        }
//        if (inEnd > idx) {
//            root.right = dfs(inorder, preorder, idx + 1, inEnd, idx - inStart + preStart + 1, preEnd);
//        }
//        return root;
//    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = search(inorder, inStart, inEnd, preorder[preStart]);
        int leftNodes = idx - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + leftNodes, inorder, inStart, idx - 1);
        root.right = buildTree(preorder, preStart + leftNodes + 1, preEnd, inorder, idx + 1, inEnd);
        return root;
    }

    private int search(int[] num, int start, int end, int target) {
        for (int i = start; i <= end; i++) {
            if (num[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = new ConstructBinaryTreeFromPreorderInorderTraversal().buildTree(new int[]{3, 1, 2, 4, 5, 6}, new int[]{2, 1, 3, 5, 4, 6});
        new ConstructBinaryTreeFromPreorderInorderTraversal().dfsPrintTree(root);
    }

    public void dfsPrintTree(TreeNode root) {
        if (root == null) return;
        System.out.println(root.val);
        dfsPrintTree(root.left);
        dfsPrintTree(root.right);
    }
}
