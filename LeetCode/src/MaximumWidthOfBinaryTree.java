import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            if (p == null) continue;
        }
        return 0;
    }
}
