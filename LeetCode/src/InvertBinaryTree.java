/**
 * Created by yaodh on 2018/1/31.
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        if (root.left != null) invertTree(root.left);
        if (root.right != null) invertTree(root.right);

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        return root;
    }
}
