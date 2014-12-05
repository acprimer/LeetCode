/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Merge Two Sorted Lists
 * Link: https://oj.leetcode.com/problems/merge-two-sorted-lists/
 * Description:
 * -----------------------------
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * -----------------------------
 * <p/>
 * Tag: LinkedList
 */
public class MergeTwoSortedLists {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1, q = l2;
        ListNode pointer = head;
        while (p != null && q != null) {
            if (p.val < q.val) {
                pointer.next = p;
                pointer = p;
                p = p.next;
            } else {
                pointer.next = q;
                pointer = q;
                q = q.next;
            }
        }
        if (p != null) pointer.next = p;
        if (q != null) pointer.next = q;
        return head.next;
    }

    public void solution() {
        ListNode head1 = new ListNode(1);
        int[] a = new int[]{2, 4, 6};
        ListNode p = head1;
        for (int i = 0; i < a.length; i++) {
            ListNode node = new ListNode(a[i]);
            p.next = node;
            p = node;
        }
        ListNode head2 = new ListNode(1);
        int[] b = new int[]{1, 3, 5};
        p = head2;
        for (int i = 0; i < b.length; i++) {
            ListNode node = new ListNode(b[i]);
            p.next = node;
            p = node;
        }
        p = mergeTwoLists(head1, head2);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    public static void main(String[] args) {
        new MergeTwoSortedLists().solution();
    }
}
