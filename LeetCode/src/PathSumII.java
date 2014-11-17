import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/17.
 *
 * LeetCode: Path Sum II
 * Link: https://oj.leetcode.com/problems/path-sum-ii/
 * Description:
 * -----------------------------
 * Given a binary tree and a sum, determine
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return
 * [
 *  [5,4,11,2],
 *  [5,8,4,5]
 * ]
 * -----------------------------
 *
 * Tag: DFS
 */
public class PathSumII {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, 0, sum, null);
        return ans;
    }

    private void dfs(TreeNode root, int sum, int target, List<Integer> path) {
        if(root == null) return;
        sum += root.val;
        List<Integer> pathCopy;
        if(path == null) {
            pathCopy = new ArrayList<Integer>();
        }
        else {
            pathCopy = new ArrayList<Integer>(path);
        }
        pathCopy.add(root.val);
        if(root.left == null && root.right == null) {
            if(sum == target) {
                ans.add(pathCopy);
            }
            return ;
        }
        dfs(root.left, sum, target, pathCopy);
        dfs(root.right, sum, target, pathCopy);
    }

    public TreeNode generateTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(0);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new PathSumII().generateTree();
        List<List<Integer>> ans = new PathSumII().pathSum(root, 6);
        for(List<Integer> line : ans) {
            for(int num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
