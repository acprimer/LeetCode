import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/17.
 *
 * LeetCode: Symmetric Tree
 * Link: https://oj.leetcode.com/problems/symmetric-tree/
 * Description:
 * -----------------------------
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 *    1
 *   / \
 *  2   2
 * / \ / \
 *3  4 4  3
 * -----------------------------
 *
 * Tag: DFS
 */
public class SymmetricTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> pathLeftToRight = new ArrayList<Integer>();
    List<Integer> pathRightToLeft = new ArrayList<Integer>();
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        dfsLeftToRight(root);
        dfsRightToLeft(root);
        for(int i=0;i<pathLeftToRight.size();i++) {
            if(pathLeftToRight.get(i).intValue() != pathRightToLeft.get(i).intValue())
                return false;
        }
        return true;
    }

    private void dfsLeftToRight(TreeNode root) {
        pathLeftToRight.add(root.val);
        if(root.left != null) {
            dfsLeftToRight(root.left);
        }
        else {
            pathLeftToRight.add(Integer.MAX_VALUE);
        }
        if(root.right != null) {
            dfsLeftToRight(root.right);
        }
        else {
            pathLeftToRight.add(Integer.MAX_VALUE);
        }
    }

    private void dfsRightToLeft(TreeNode root) {
        pathRightToLeft.add(root.val);
        if(root.right != null) {
            dfsRightToLeft(root.right);
        }
        else {
            pathRightToLeft.add(Integer.MAX_VALUE);
        }
        if(root.left != null) {
            dfsRightToLeft(root.left);
        }
        else {
            pathRightToLeft.add(Integer.MAX_VALUE);
        }
    }

    public TreeNode generateTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
//        root.left = node1;
//        root.right = node2;
//        node1.left = node3;
//        node2.right = node4;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new SymmetricTree().generateTree();
        boolean ans = new SymmetricTree().isSymmetric(root);
        System.out.println(ans);
    }
}
