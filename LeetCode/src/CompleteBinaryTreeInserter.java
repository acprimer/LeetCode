import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yaodh on 2018/10/18.
 */
public class CompleteBinaryTreeInserter {
    static class CBTInserter {
        private TreeNode root;
        private Queue<TreeNode> queue;

        public CBTInserter(TreeNode root) {
            this.root = root;
            queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.peek();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
                if (node.left != null && node.right != null) {
                    queue.poll();
                } else {
                    break;
                }
            }
        }

        public int insert(int v) {
            TreeNode node = queue.peek();
            if (node.left == null) {
                node.left = new TreeNode(v);
                queue.offer(node.left);
            } else if (node.right == null) {
                node.right = new TreeNode(v);
                queue.offer(node.right);
                queue.poll();
            }
            return node.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        root.left = n2;
        root.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        CBTInserter obj = new CBTInserter(root);
//        System.out.println(obj.insert(2));
//        System.out.println(obj.insert(3));
//        System.out.println(obj.insert(4));
//        System.out.println(obj.insert(5));
//        System.out.println(obj.insert(6));
        System.out.println(obj.insert(7));
        System.out.println(obj.insert(8));
        System.out.println(obj.insert(9));
    }
}
