/**
 * Created by yaodh on 2014/11/13.
 *
 * LeetCode: Sum Root to Leaf Numbers
 * Link: https://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 * Description:
 * -----------------------------
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 *     1
 *    / \
 *   2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 * -----------------------------
 *
 * Tag: DFS
 */


//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SumRootToLeafNumbers {
    int ans;
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        ans = 0;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode root, int curNum) {
        curNum = curNum * 10 + root.val;
        if(root.left == null && root.right == null) {
            ans += curNum;
            return ;
        }
        if(root.left != null) {
            dfs(root.left, curNum);
        }
        if(root.right != null) {
            dfs(root.right, curNum);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node1;
        root.right = node2;
        int ans = new SumRootToLeafNumbers().sumNumbers(root);
        System.out.print(ans);
    }
}
