/**
 * Created by yaodh on 2014/11/21.
 * <p/>
 * LeetCode: Remove Duplicates from Sorted List II
 * Link: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * Description:
 * -----------------------------
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * -----------------------------
 * <p/>
 * Tag: LinkedList
 */
public class RemoveDuplicatesFromSortedListII {
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
        ListNode newHead = new ListNode(0);
        newHead.next = null;
        ListNode p = head, last = newHead;
        while (p != null) {
            ListNode first = p;
            int count = 0;
            while (p != null && p.val == first.val) {
                p = p.next;
                count++;
            }
            if (count > 1) continue;
            first.next = null;
            last.next = first;
            last = first;
        }
        return newHead.next;
    }

    public void solution() {
        ListNode head = new ListNode(0);
        ListNode p = head;
        int[] a = new int[]{1, 2, 3, 3, 4, 4, 4, 4, 5, 5, 8};
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
        new RemoveDuplicatesFromSortedListII().solution();
    }
}
