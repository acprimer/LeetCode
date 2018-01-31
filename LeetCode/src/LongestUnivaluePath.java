/**
 * Created by yaodh on 2018/1/31.
 */
public class LongestUnivaluePath {

    int max = 0;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left) + 1;
        if (root.left == null || root.val != root.left.val) {
            left = 0;
        }
        int right = dfs(root.right) + 1;
        if (root.right == null || root.val != root.right.val) {
            right = 0;
        }
        max = Math.max(max, left + right);
        return Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree();
        System.out.println(new LongestUnivaluePath().longestUnivaluePath(root));
    }
}
