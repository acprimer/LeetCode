/**
 * Created by yaodh on 15/10/21.
 */
public class TreeNode {
    public int val;
    public TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode generateTree() {
//        TreeNode node3 = new TreeNode(4);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node1 = new TreeNode(4, node3, node4);
//        TreeNode node2 = new TreeNode(5, null, node5);
//        TreeNode root = new TreeNode(1, node1, node2);
        TreeNode node6 = new TreeNode(1);
        TreeNode node5 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node2 = new TreeNode(1, node5, node6);
        TreeNode node1 = new TreeNode(0, node3, node4);
        TreeNode root = new TreeNode(1, node1, node2);
        return root;
    }
}
