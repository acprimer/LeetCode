/**
 * Created by yaodh on 2015/1/15.
 * <p/>
 * LeetCode: Reorder List
 * Link: https://oj.leetcode.com/problems/reorder-list/
 * Description:
 * -----------------------------
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * -----------------------------
 * <p/>
 * Tag: LinkedList
 */
public class ReorderList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        reverse(slow);
        ListNode second = slow.next;
        slow.next = null;
        merge(head, second);
    }

    private void merge(ListNode first, ListNode second) {
        while (first != null && second != null) {
            ListNode p = first.next;
            first.next = second;
            ListNode q = second.next;
            second.next = p;
            first = p;
            second = q;
        }
    }

    private void reverse(ListNode head) {
        ListNode p = head.next;
        head.next = null;
        while (p != null) {
            ListNode q = p.next;
            p.next = head.next;
            head.next = p;
            p = q;
        }
    }
}
