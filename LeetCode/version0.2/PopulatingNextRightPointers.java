import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yaodh on 2014/11/16.
 *
 * LeetCode: Populating Next Right Pointers in Each Node
 * Link: https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * Description:
 * -----------------------------
 * Given a binary tree
 *    struct TreeLinkNode {
 *      TreeLinkNode *left;
 *      TreeLinkNode *right;
 *      TreeLinkNode *next;
 *   }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 *
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * -----------------------------
 *
 * Tag: Queue
 */
public class PopulatingNextRightPointers {
    //Definition for binary tree with next pointer.
    private class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        public TreeLinkNode(int x) {
            val = x;
        }
    }
    class TreeLinkNodeWithLavel {
        int level;
        TreeLinkNode node;

        TreeLinkNodeWithLavel(TreeLinkNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public void connect(TreeLinkNode root) {
        if(root == null
                || (root.left == null && root.right == null)) {
            return;
        }
        Queue<TreeLinkNodeWithLavel> queue = new LinkedList<TreeLinkNodeWithLavel>();
        queue.offer(new TreeLinkNodeWithLavel(root, 1));
        while(!queue.isEmpty()) {
            TreeLinkNodeWithLavel nodeWithLavel = queue.poll();
            TreeLinkNode node = nodeWithLavel.node;
            int level = nodeWithLavel.level;
            if(node.left != null) {
                queue.offer(new TreeLinkNodeWithLavel(node.left, level+1));
            }
            if(node.right != null) {
                queue.offer(new TreeLinkNodeWithLavel(node.right, level+1));
            }
            if(!queue.isEmpty() && queue.peek().level == level) {
                node.next = queue.peek().node;
            }
            else {
                node.next = null;
            }
        }
    }

    public TreeLinkNode generateTree() {
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode left = new TreeLinkNode(2);
        TreeLinkNode right = new TreeLinkNode(3);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        PopulatingNextRightPointers solution = new PopulatingNextRightPointers();
        TreeLinkNode root = solution.generateTree();
        solution.connect(root);
        System.out.println(root.next);
        System.out.println(root.left.next.val);
        System.out.println(root.right.next);
    }

}
