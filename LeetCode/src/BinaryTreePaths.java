import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2018/11/8.
 */
public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        root.left = n2;
        root.right = new TreeNode(3);
        n2.right = new TreeNode(5);
        n2.left = new TreeNode(6);
        for (String s : new BinaryTreePaths().binaryTreePaths(root)) {
            System.out.println(s);
        }
    }

//    private List<List<TreeNode>> pathList = new ArrayList<>();
//    public List<String> binaryTreePaths(TreeNode root) {
//        if (root == null) return new ArrayList<>();
//        dfs(new ArrayList<>(), root);
//        List<String> ans = new ArrayList<>(pathList.size());
//        for (List<TreeNode> list : pathList) {
//            ans.add(generatePath(list));
//        }
//        return ans;
//    }
//
//    private void dfs(List<TreeNode> path, TreeNode root) {
//        path.add(root);
//        if (root.left == null && root.right == null) {
//            pathList.add(path);
//            return;
//        }
//        List<TreeNode> temp = new ArrayList<>(path);
//        if (root.left == null) {
//            dfs(path, root.right);
//        } else {
//            dfs(path, root.left);
//            if (root.right != null) {
//                dfs(temp, root.right);
//            }
//        }
//    }

    private String generatePath(List<TreeNode> path) {
        if (path == null || path.size() <= 0) return "";
        StringBuilder builder = new StringBuilder();
        builder.append(String.valueOf(path.get(0).val));
        for (int i = 1; i < path.size(); i++) {
            builder.append("->");
            builder.append(String.valueOf(path.get(i).val));
        }
        return builder.toString();
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;

        List<List<TreeNode>> paths = new ArrayList<>();
        addRoot(paths, root);
        boolean finished = false;
        while (!finished) {
            finished = true;
            List<List<TreeNode>> dup = new ArrayList<>();
            for (List<TreeNode> path : paths) {
                TreeNode last = path.get(path.size() - 1);
                if (last.left == null && last.right == null) continue;
                finished = false;
                if (last.left != null && last.right == null) {
                    path.add(last.left);
                }
                if (last.left == null && last.right != null) {
                    path.add(last.right);
                }
                if (last.left != null && last.right != null) {
                    List<TreeNode> temp = new ArrayList<>(path);
                    path.add(last.left);
                    temp.add(last.right);
                    dup.add(temp);
                }
            }
            if (dup.size() > 0) paths.addAll(dup);
        }
        for (List<TreeNode> list : paths) {
            ans.add(generatePath(list));
        }
        return ans;
    }

    private void addRoot(List<List<TreeNode>> path, TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        path.add(list);
    }
}
