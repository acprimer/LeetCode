import java.util.HashSet;
import java.util.Set;

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

    // two pointers: fast pointer moves 2 steps, slow pointer moves 1 step
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null) {
            if (fast == slow) {
                return true;
            }
            fast = fast.next;
            slow = slow.next;
            if (fast != null) fast = fast.next;
        }
        return false;
    }

    // reverse the linked list
    // if has cycle: the new head pointer equals to the old head pointer
    // if not: the new head pointer equals to the old last pointer
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode h2 = new ListNode(0);
        ListNode old = head;
        while (head != null) {
            ListNode p = head.next;
            head.next = h2.next;
            h2.next = head;
            head = p;
        }
        return old == h2.next;
    }

    // hashset
    public boolean hasCycle3(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while(head != null && !set.contains(head)) {
            set.add(head);
            head = head.next;
        }
        return head != null;
    }

    public ListNode generate() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n2;
        return n1;
    }

    public static void main(String[] args) {
        boolean ans = new LinkedListCycle().hasCycle3(new LinkedListCycle().generate());
        System.out.println(ans);
    }
}
