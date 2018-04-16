/**
 * Created by yaodh on 2018/4/16.
 */
public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.left == null && root.right == null && root.val == 0) {
            root = null;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree();
        root = new BinaryTreePruning().pruneTree(root);
    }
}
