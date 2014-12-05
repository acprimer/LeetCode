/**
 * Created by yaodh on 2014/11/28.
 * <p/>
 * LeetCode: Remove Nth Node From End of List
 * Link: https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Description:
 * -----------------------------
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * -----------------------------
 * <p/>
 * Tag: TwoPointers
 */
public class RemoveNthNodeFromEndOfList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = newHead, q = newHead, pre = newHead;
        while (n-- > 0) p = p.next;
        while (p != null) {
            p = p.next;
            pre = q;
            q = q.next;
        }
        if (q == null) pre.next = null;
        else pre.next = q.next;
        return newHead.next;
    }

    public void solution() {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i < 6; i++) {
            ListNode node = new ListNode(i);
            p = p.next = node;
        }
        head = removeNthFromEnd(head, 5);
        p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        new RemoveNthNodeFromEndOfList().solution();
    }
}
