public class ConstructBinarySearchTreeFromPreorderTraversal {
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;
        int n = preorder.length;
        return bstFromPreorder(preorder, 0, n - 1);
    }

    public TreeNode bstFromPreorder(int[] preorder, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(preorder[start]);
        if (start == end) return root;
        int idx = start + 1;
        while (idx <= end && preorder[idx] < root.val) idx++;
        root.left = bstFromPreorder(preorder, start + 1, idx - 1);
        root.right = bstFromPreorder(preorder, idx, end);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new ConstructBinarySearchTreeFromPreorderTraversal()
                .bstFromPreorder(new int[]{
                8, 5, 1, 7, 10, 12
        });
        root.print();
    }
}
