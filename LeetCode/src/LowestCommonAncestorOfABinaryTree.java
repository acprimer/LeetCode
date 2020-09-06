import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2015/7/26.
 */
public class LowestCommonAncestorOfABinaryTree {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<TreeNode> list = new ArrayList<TreeNode>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p);
        List<TreeNode> plist = new ArrayList<TreeNode>();
        plist.addAll(list);
        list.clear();
        dfs(root, q);
        List<TreeNode> qlist = list;
        TreeNode ans = null;
        for (int i = 0; i < plist.size() && i < qlist.size(); i++) {
            if (plist.get(i) == qlist.get(i)) {
                ans = plist.get(i);
            } else {
                break;
            }
        }
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p) {
        list.add(root);
        if (p != root) {
            if (root.left != null) {
                if (dfs(root.left, p)) {
                    return true;
                }
                list.remove(root.left);
            }
            if (root.right != null) {
                if (dfs(root.right, p)) {
                    return true;
                }
                list.remove(root.right);
            }
            return false;
        } else {
            return true;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> first = new ArrayList<>();
        List<TreeNode> second = new ArrayList<>();
        first.add(root);
        second.add(root);
        if (find(first, root, p) && find(second, root, q)) {
            TreeNode result = null;
            for (int i = 0; i < first.size() && i < second.size(); i++) {
                if (first.get(i) == second.get(i)) {
                    result = first.get(i);
                } else {
                    break;
                }
            }
            return result;
        } else {
            return null;
        }
    }

    public boolean find(List<TreeNode> list, TreeNode root, TreeNode p) {
        if (root == null) return false;
        if (p == root) {
            return true;
        }
        list.add(root.left);
        if (find(list, root.left, p)) {
            return true;
        } else {
            list.remove(root.left);
        }
        list.add(root.right);
        if (find(list, root.right, p)) {
            return true;
        } else {
            list.remove(root.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode tree = new LowestCommonAncestorOfABinaryTree().gen(new int[]{1, 2, 3});
        TreeNode ans = new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor2(tree, tree.left, tree.right);
        System.out.println(ans.val);
    }

    private TreeNode gen(int vals[]) {
        TreeNode tree = new TreeNode(0);
        TreeNode a = new TreeNode(vals[0]);
        TreeNode b = new TreeNode(vals[1]);
        TreeNode c = new TreeNode(vals[2]);
        tree.left = a;
        tree.right = b;
        a.left = c;
        return tree;
    }
}
