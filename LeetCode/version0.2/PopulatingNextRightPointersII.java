import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yaodh on 2014/11/16.
 *
 * LeetCode: Populating Next Right Pointers in Each Node II
 * Link: https://oj.leetcode.com/problems/palindrome-partitioning-ii/
 * Description:
 * -----------------------------
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * -----------------------------
 *
 * Tag: Queue
 */
public class PopulatingNextRightPointersII {
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
        PopulatingNextRightPointersII solution = new PopulatingNextRightPointersII();
        TreeLinkNode root = solution.generateTree();
        solution.connect(root);
        System.out.println(root.next);
        System.out.println(root.left.next.val);
        System.out.println(root.right.next);
    }

}
