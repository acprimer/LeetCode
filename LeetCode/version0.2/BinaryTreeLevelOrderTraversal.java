import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * Created by yaodh on 2014/11/17.
 *
 * LeetCode: Binary Tree Level Order Traversal
 * Link: https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 * Description:
 * -----------------------------
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *   3
 *  / \
 * 9  20
 *   /  \
 *  15   7
 * return its level order traversal as:
 * [
 *  [3],
 *  [9,20],
 *  [15,7]
 * ]
 * -----------------------------
 *
 * Tag: BFS
 */
public class BinaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        Queue<TreeNodeWithLevel> queue = new LinkedList<TreeNodeWithLevel>();
        queue.offer(new TreeNodeWithLevel(root, 0));
        int preLevel = -1;
        while(!queue.isEmpty()) {
            TreeNodeWithLevel head = queue.poll();
            TreeNode node =head.node;
            int level = head.level;
            if(level == preLevel) {
                ans.get(preLevel).add(node.val);
            }
            else {
                List<Integer> levelList = new ArrayList<Integer>();
                ans.add(levelList);
                levelList.add(node.val);
                preLevel = level;
            }
            if(node.left != null) {
                queue.offer(new TreeNodeWithLevel(node.left, level + 1));
            }
            if(node.right != null) {
                queue.offer(new TreeNodeWithLevel(node.right, level + 1));
            }
        }
        return ans;
    }

    public TreeNode generateTree() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new BinaryTreeLevelOrderTraversal().generateTree();
        List<List<Integer>> ans = new BinaryTreeLevelOrderTraversal().levelOrder(root);
        for(List<Integer> line : ans) {
            for(int num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
