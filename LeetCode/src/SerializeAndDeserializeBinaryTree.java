import java.util.*;

/**
 * Created by yaodh on 15/10/26.
 */
public class SerializeAndDeserializeBinaryTree {
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        Queue<TreeNode> q = new LinkedList<>();
//        q.offer(root);
//        while (!q.isEmpty()) {
//            TreeNode node = q.poll();
//            if(node == null) {
//                list.add(null);
//            } else {
//                list.add(node.val);
//                q.offer(node.left);
//                q.offer(node.right);
//            }
//        }
//        return Arrays.toString(list.toArray());
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        String[] nums = data.substring(1, data.length()-1).split(",");
//        return dfs(nums);
//    }
//
//    private static int idx = 0;
//
//    private TreeNode dfs(String[] nums) {
//        if(idx >= nums.length || nums[idx].trim().equals("null")) {
//            return null;
//        }
//        TreeNode root = new TreeNode(Integer.parseInt(nums[idx].trim()));
//        idx++;
//        root.left = dfs(nums);
//        idx++;
//        root.right = dfs(nums);
//        return root;
//    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(0);
//        TreeNode node = new TreeNode(1);
//        root.right = node;
//        String str = new SerializeAndDeserializeBinaryTree().serialize(root);
//        System.out.println(str);
//        TreeNode n = new SerializeAndDeserializeBinaryTree().deserialize("[5,2,3,null,null,2,4,3,1]");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String str = new SerializeAndDeserializeBinaryTree().serialize(root);
        System.out.println(str);
        TreeNode r = new SerializeAndDeserializeBinaryTree().deserialize("1[2]");
        System.out.println(r);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder builder = new StringBuilder();
        builder.append(root.val);
        if (root.left != null) {
            builder.append('(');
            builder.append(serialize(root.left));
            builder.append(')');
        }
        if (root.right != null) {
            builder.append('[');
            builder.append(serialize(root.right));
            builder.append(']');
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() <= 0) return null;
        int i = 0;
        while (i < data.length()) {
            if (data.charAt(i) == '-' || Character.isDigit(data.charAt(i))) i++;
            else break;
        }
        TreeNode root = new TreeNode(Integer.parseInt(data.substring(0, i)));

        if (i < data.length() && data.charAt(i) == '(') {
            int leftCount = 0;
            int leftStart = i+1;
            while (i < data.length()) {
                if (data.charAt(i) == '(') {
                    leftCount++;
                } else if (data.charAt(i) == ')') {
                    leftCount--;
                    if (leftCount == 0) break;
                }
                i++;
            }
            i++;
            root.left = deserialize(data.substring(leftStart, i));
        }

        if (i < data.length() && data.charAt(i) == '[') {
            int rightCount = 0;
            int rightStart = i+1;
            while (i < data.length()) {
                if (data.charAt(i) == '[') {
                    rightCount++;
                } else if (data.charAt(i) == ']') {
                    rightCount--;
                    if (rightCount == 0) break;
                }
                i++;
            }
            root.right = deserialize(data.substring(rightStart, i));
        }
        return root;
    }
}
