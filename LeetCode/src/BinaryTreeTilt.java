public class BinaryTreeTilt {
    private int ans = 0;
    public int findTilt(TreeNode root) {
        findSum(root);
        return ans;
    }

    public int findSum(TreeNode root) {
        if (root == null) return 0;
        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);
        ans += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(5);
        tree.left.left = new TreeNode(3);
        tree.left.right = new TreeNode(4);

        System.out.println(new BinaryTreeTilt().findTilt(tree));
    }
}
