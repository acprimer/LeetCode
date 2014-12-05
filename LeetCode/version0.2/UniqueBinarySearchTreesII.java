import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/19.
 *
 * LeetCode: Unique Binary Search Trees II
 * Link: https://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 * Description:
 * -----------------------------
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *     1         3     3      2      1
 *      \       /     /      / \      \
 *       3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 * -----------------------------
 *
 * Tag: DFS
 */
public class UniqueBinarySearchTreesII {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    int[] array;
    public List<TreeNode> generateTrees(int n) {
        array = new int[n];
        for(int i=0;i<n;i++) {
            array[i] = i+1;
        }
        return dfs(0, n-1);
    }

    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(start > end) {
            list.add(null);
            return list;
        }
        if(start == end) {
            TreeNode root = new TreeNode(array[start]);
            list.add(root);
            return list;
        }
        for(int i=start;i<=end;i++) {
            List<TreeNode> leftList = dfs(start, i-1);
            List<TreeNode> rightList = dfs(i+1, end);
            for(TreeNode leftRoot : leftList) {
                for(TreeNode rightRoot : rightList) {
                    TreeNode root = new TreeNode(array[i]);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    list.add(root);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<TreeNode> ans = new UniqueBinarySearchTreesII().generateTrees(3);
        for(TreeNode root : ans) {
            dfsPrintTree(root);
            System.out.println();
        }
    }

    public static void dfsPrintTree(TreeNode root) {
        if(root == null) return;
        dfsPrintTree(root.left);
        System.out.print(root.val + " ");
        dfsPrintTree(root.right);
    }
}
