/**
 * Created by yaodh on 2014/11/21.
 *
 * LeetCode: Partition List
 * Link: https://oj.leetcode.com/problems/partition-list/
 * Description:
 * -----------------------------
 * Given a linked list and a value x, partition it
 * such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * -----------------------------
 *
 * Tag: LinkedList
 */
public class PartitionList {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode p = head;
        ListNode smallFirst = null, smallLast = null;
        ListNode largeFirst = null, largeLast = null;
        while (p != null) {
            ListNode q = p.next;
            p.next = null;
            if (p.val >= x) {
                if (largeLast == null) {
                    largeFirst = largeLast = p;
                } else {
                    largeLast.next = p;
                    largeLast = p;
                }
            } else {
                if (smallLast == null) {
                    smallFirst = smallLast = p;
                } else {
                    smallLast.next = p;
                    smallLast = p;
                }
            }
            p = q;
        }
        if(smallFirst != null) {
            smallLast.next = largeFirst;
        }
        return smallFirst == null ? largeFirst : smallFirst;
    }

    public void solution() {
        ListNode head = new ListNode(1);
        ListNode p = head;
        int[] a = new int[]{4, 3, 2, 5, 2};
        for (int i = 0; i < a.length; i++) {
            ListNode node = new ListNode(a[i]);
            p.next = node;
            p = node;
        }
        head = partition(head, 3);
        p = head;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }

    public static void main(String[] args) {
        new PartitionList().solution();
    }
}
