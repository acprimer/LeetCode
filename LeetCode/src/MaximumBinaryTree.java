public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if (start >= end) return null;

        int max = nums[start];
        int maxIndex = start;
        for (int i = start+1; i < end; i++) {
            if (max < nums[i]) {
                max = nums[maxIndex = i];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(nums, start, maxIndex);
        root.right = constructMaximumBinaryTree(nums, maxIndex+1, end);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
        System.out.println(root);
    }
}
