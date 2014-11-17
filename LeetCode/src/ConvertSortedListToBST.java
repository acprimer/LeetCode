import java.util.ArrayList;
import java.util.List;
/**
 * Created by yaodh on 2014/11/17.
 *
 * LeetCode: Convert Sorted List to Binary Search Tree
 * Link: https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * Description:
 * -----------------------------
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 * -----------------------------
 *
 * Tag: BST
 */
public class ConvertSortedListToBST {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        List<Integer> array = new ArrayList<Integer>();
        while(head != null) {
            array.add(head.val);
            head = head.next;
        }
        int[] num = new int[array.size()];
        for(int i=0;i<array.size();i++) {
            num[i] = array.get(i);
        }
        return build(num, 0, num.length-1);
    }

    private TreeNode build(int[] num, int start, int end) {
        if(start > end) return null;
        int mid = (start + end) >> 1;
        TreeNode root = new TreeNode(num[mid]);
        root.left = build(num, start, mid-1);
        root.right = build(num, mid+1, end);
        return root;
    }

    public void dfs(TreeNode root) {
        if(root == null) return;
        System.out.println(root.val);
        dfs(root.left);
        dfs(root.right);
    }

}
