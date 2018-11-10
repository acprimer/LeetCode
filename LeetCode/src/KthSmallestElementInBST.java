import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
    private List<Integer> bst = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        return bst.get(k-1);
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        bst.add(root.val);
        dfs(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        System.out.println(new KthSmallestElementInBST().kthSmallest(root, 4));
    }
}
