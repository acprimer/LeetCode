/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Rotate List
 * Link: https://oj.leetcode.com/problems/rotate-list/
 * Description:
 * -----------------------------
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * -----------------------------
 * <p/>
 * Tag: LinkedList
 */
public class RotateList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode rotateRight(ListNode head, int n) {
        if (n == 0 || head == null || head.next == null) return head;
        ListNode p, last, q;
        p = last = head;
        int count = 0;
        while (p != null) {
            last = p;
            p = p.next;
            count++;
        }
        n = n % count;
        if (n == 0) return head;
        p = q = head;
        while (count > n && p != null) {
            q = p;
            p = p.next;
            count--;
        }
        last.next = head;
        q.next = null;
        return p;
    }

    public void solution() {
        ListNode head = new ListNode(1), p = head;
        for (int i = 2; i <= 5; i++) {
            ListNode node = new ListNode(i);
            p.next = node;
            p = node;
        }
        head = rotateRight(head, 3);
        p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    public static void main(String[] args) {
        new RotateList().solution();
    }
}
