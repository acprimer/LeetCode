/**
 * Created by yaodh on 2015/4/17.
 *
 * LeetCode: Binary Search Tree Iterator
 * Link: https://leetcode.com/problems/binary-search-tree-iterator/
 * Description:
 * -----------------------------
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * -----------------------------
 *
 * Tag: Stack
 */

import java.util.Stack;

public class BinarySearchTreeIterator {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class BSTIterator {
        public Stack<TreeNode> stack = new Stack<TreeNode>();

        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            int ans = stack.peek().val;
            TreeNode node = stack.pop().right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            return ans;
        }
    }
}
