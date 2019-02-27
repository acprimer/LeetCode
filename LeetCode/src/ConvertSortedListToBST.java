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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;

        ListNode fast = head, slow =head;
        ListNode p = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            p = slow;
            slow = slow.next;
        }
        if (p != null) p.next = null;
        else head = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new ConvertSortedListToBST().sortedListToBST(ListNode.generate(-10, -3, 0, 5, 9));
        root.print();
    }
}
