/**
 * Created by yaodh on 2014/11/17.
 *
 * LeetCode: Path Sum
 * Link: https://oj.leetcode.com/problems/path-sum/
 * Description:
 * -----------------------------
 * Given a binary tree and a sum, determine
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * -----------------------------
 *
 * Tag: DFS
 */

public class PathSum {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, 0, sum);
    }

    private boolean dfs(TreeNode root, int sum, int target) {
        if(root == null) return false;
        sum += root.val;
        if(root.left == null && root.right == null) {
            return sum == target;
        }
        return dfs(root.left, sum, target) || dfs(root.right, sum, target);
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
        TreeNode root = new PathSum().generateTree();
        boolean ans = new PathSum().hasPathSum(root, 12);
        System.out.println(ans);
    }
}
