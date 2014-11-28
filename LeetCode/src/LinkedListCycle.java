/**
 * Created by yaodh on 2014/11/4.
 * <p/>
 * LeetCode: Linked List Cycle
 * Link: https://oj.leetcode.com/problems/linked-list-cycle/
 * Description:
 * -----------------------------
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 * -----------------------------
 * <p/>
 * Tag: LinkedList
 */
public class LinkedListCycle {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p = head;
        ListNode q = head.next;
        while (q != null) {
            if (p == q) {
                return true;
            }
            p = p.next;
            q = q.next;
            if (q != null) q = q.next;
        }
        return false;
    }
}
