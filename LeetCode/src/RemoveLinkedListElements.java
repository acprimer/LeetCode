/**
 * Created by yaodh on 2015/4/23.
 * <p/>
 * LeetCode: Remove Linked List Elements
 * Link: https://leetcode.com/problems/remove-linked-list-elements/
 * Description:
 * -----------------------------
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * -----------------------------
 * <p/>
 * Tag: LinkedList
 */
public class RemoveLinkedListElements {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (head != null) {
            if (head.val == val) {
                p.next = head.next;
            } else {
                p.next = head;
                p = p.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
