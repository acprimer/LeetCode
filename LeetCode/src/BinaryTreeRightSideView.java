import java.util.ArrayList;
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
        ans.add(root.val);
        int length = 1;
        for(int i=0;i<length;i++) {
        }
        return ans;
    }
}
