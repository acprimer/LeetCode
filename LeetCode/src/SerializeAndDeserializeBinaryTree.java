import java.util.*;

/**
 * Created by yaodh on 15/10/26.
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node == null) {
                list.add(null);
            } else {
                list.add(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
        }
        return Arrays.toString(list.toArray());
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nums = data.substring(1, data.length()-1).split(",");
        return dfs(nums);
    }

    private static int idx = 0;

    private TreeNode dfs(String[] nums) {
        if(idx >= nums.length || nums[idx].trim().equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nums[idx].trim()));
        idx++;
        root.left = dfs(nums);
        idx++;
        root.right = dfs(nums);
        return root;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(0);
//        TreeNode node = new TreeNode(1);
//        root.right = node;
//        String str = new SerializeAndDeserializeBinaryTree().serialize(root);
//        System.out.println(str);
        TreeNode n = new SerializeAndDeserializeBinaryTree().deserialize("[5,2,3,null,null,2,4,3,1]");
        printNode(n);
    }

    private static void printNode(TreeNode n) {
        if(n == null) {
            return;
        }
        System.out.println(n.val);
        printNode(n.left);
        printNode(n.right);
    }
}
