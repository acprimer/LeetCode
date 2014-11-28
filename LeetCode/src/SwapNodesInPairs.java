/**
 * Created by yaodh on 2014/11/28.
 * <p/>
 * LeetCode: Swap Nodes in Pairs
 * Link: https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 * Description:
 * -----------------------------
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 * -----------------------------
 * <p/>
 * Tag: LinkedList
 */
public class SwapNodesInPairs {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode p = head, pre = newHead;
        while (p != null && p.next != null) {
            pre.next = p.next;
            p.next = p.next.next;
            pre.next.next = p;
            pre = p;
            p = p.next;
        }
        return newHead.next;
    }

    public void solution() {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i < 3; i++) {
            ListNode node = new ListNode(i);
            p = p.next = node;
        }
        p = swapPairs(head);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        new SwapNodesInPairs().solution();
    }
}
