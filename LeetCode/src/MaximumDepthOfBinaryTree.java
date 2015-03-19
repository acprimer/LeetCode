import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yaodh on 2014/11/17.
 *
 * LeetCode: Maximum Depth of Binary Tree
 * Link: https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
 * Description:
 * -----------------------------
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * -----------------------------
 *
 * Tag: BFS
 */
public class MaximumDepthOfBinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    class TreeNodeWithLevel{
        TreeNode node;
        int level;
        TreeNodeWithLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNodeWithLevel> queue = new LinkedList<TreeNodeWithLevel>();
        queue.offer(new TreeNodeWithLevel(root, 1));
        int ans = 1;
        while(!queue.isEmpty()) {
            TreeNodeWithLevel head = queue.poll();
            TreeNode node =head.node;
            int level = head.level;
            ans = Math.max(ans, level);
            if(node.left != null) {
                queue.offer(new TreeNodeWithLevel(node.left, level + 1));
            }
            if(node.right != null) {
                queue.offer(new TreeNodeWithLevel(node.right, level + 1));
            }
        }
        return ans;
    }

    public int maxDepth2(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
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
//        node2.right = node5;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new MaximumDepthOfBinaryTree().generateTree();
        int ans = new MaximumDepthOfBinaryTree().maxDepth(root);
        System.out.println(ans);
    }
}
