import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by yaodh on 2015/4/9.
 */
public class BinaryTreeRightSideView {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) {
            return ans;
        }
        List<TreeNode> cur = new LinkedList<TreeNode>();
        cur.add(root);
        List<TreeNode> next = new LinkedList<TreeNode>();
        while(cur.size() > 0) {
            int val = cur.get(0).val;
            if(cur.get(0).left != null) {
                next.add(cur.get(0).left);
            }
            if(cur.get(0).right != null) {
                next.add(cur.get(0).right);
            }
            cur.remove(0);
            if(cur.size() == 0) {
                ans.add(val);
                List<TreeNode> tmp = cur;
                cur = next;
                next = tmp;
            }

        }
        return ans;
    }
}
