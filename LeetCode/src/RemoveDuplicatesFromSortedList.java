/**
 * Created by yaodh on 2014/11/21.
 * <p/>
 * LeetCode: Remove Duplicates from Sorted List
 * Link: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 * Description:
 * -----------------------------
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * -----------------------------
 * <p/>
 * Tag: LinkedList
 */
public class RemoveDuplicatesFromSortedList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode p = head.next;
        ListNode last = head;
        while (p != null) {
            while (p != null && p.val == last.val) {
                p = p.next;
            }
            last.next = p;
            if (p == null) break;
            last = p;
            p = p.next;
        }
        return head;
    }

    public void solution() {
        ListNode head = new ListNode(1);
        ListNode p = head;
        int[] a = new int[]{1, 3, 3, 4, 4, 4, 4};
        for (int i = 0; i < a.length; i++) {
            ListNode node = new ListNode(a[i]);
            p.next = node;
            p = node;
        }
        head = deleteDuplicates(head);
        p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        new RemoveDuplicatesFromSortedList().solution();
    }
}
