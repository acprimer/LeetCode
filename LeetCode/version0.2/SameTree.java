import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/17.
 *
 * LeetCode: Same Tree
 * Link: https://oj.leetcode.com/problems/same-tree/
 * Description:
 * -----------------------------
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * -----------------------------
 *
 * Tag: DFS
 */
public class SameTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pathP = new ArrayList<Integer>();
        List<Integer> pathQ = new ArrayList<Integer>();
        if(p == null && q == null) return true;
        if((p == null && q != null)
                || (p != null && q == null)) {
            return false;
        }
        dfsLeftToRight(p, pathP);
        dfsLeftToRight(q, pathQ);
        for(int i=0;i< pathP.size();i++) {
            if(pathP.get(i).intValue() != pathQ.get(i).intValue())
                return false;
        }
        return true;
    }

    private void dfsLeftToRight(TreeNode root, List<Integer> path) {
        path.add(root.val);
        if(root.left != null) {
            dfsLeftToRight(root.left, path);
        }
        else {
            path.add(Integer.MAX_VALUE);
        }
        if(root.right != null) {
            dfsLeftToRight(root.right, path);
        }
        else {
            path.add(Integer.MAX_VALUE);
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
        TreeNode root = new SameTree().generateTree();
        boolean ans = new SameTree().isSameTree(root, root);
        System.out.println(ans);
    }
}
