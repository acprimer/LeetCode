public class DiameterOfBinaryTree {
    private int ans = 0;

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.generateTree();
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(treeNode));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left) + leaf(root.left);
        int right = dfs(root.right) + leaf(root.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right);
    }

    private int leaf(TreeNode node) {
        if (node == null) return 0;
        return 1;
    }
}
