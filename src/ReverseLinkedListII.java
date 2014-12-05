/**
 * Created by yaodh on 2014/11/19.
 *
 * LeetCode: Reverse Linked List II
 * Link: https://oj.leetcode.com/problems/reverse-linked-list-ii/
 * Description:
 * -----------------------------
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 1 ≤ m ≤ n ≤ length of list.
 * -----------------------------
 *
 * Tag: Linked List
 */
public class ReverseLinkedListII {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int idx = 0;
        ListNode p = head, newHead = null;
        ListNode pre = null, first = null, last = null;
        while(p != null) {
            idx++;
            if(idx > n) break;
            ListNode q = p.next;
            if(idx < m) {
                pre = p;
            }
            else if(idx == m) {
                newHead = first = last = p;
                last.next = null;
            }
            else if(idx > m) {
                p.next = first;
                first = p;
                if(pre != null) pre.next = p;
                else newHead = p;
            }
            p = q;
        }
        last.next = p;
        return m == 1 ? newHead : head;
    }

    public void solution() {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for(int i=2;i<=6;i++) {
            ListNode node = new ListNode(i);
            p.next = node;
            p = node;
        }
        p = head;
        while(p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
        head = reverseBetween(head, 1, 4);
        p = head;
        while(p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    public static void main(String[] args) {
        new ReverseLinkedListII().solution();
    }
}
