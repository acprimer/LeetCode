/**
 * Created by yaodh on 2014/11/28.
 * <p/>
 * LeetCode: Intersection of Two Linked Lists
 * Link: https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 * Description:
 * -----------------------------
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:          a1 → a2
 *                   ↘
 *                    c1 → c2 → c3
 *                   ↗
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * -----------------------------
 * <p/>
 * Tag: LinkedList
 */
public class IntersectionOfTwoLinkedLists {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p = headA, q = headA;
        while (p != null) {
            q = p;
            p = p.next;
        }
        q.next = headB;
        ListNode ans = detectCycle(headA);
        q.next = null;
        return ans;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        while (q != null) {
            p = p.next;
            q = q.next;
            if (q != null) q = q.next;
            else return null;
            if (p == q) {
                break;
            }
        }
        if (q == null) return null;
        p = head;
        while (true) {
            if (p == q) return p;
            p = p.next;
            q = q.next;
        }
    }

    public void solution() {
        ListNode head1 = new ListNode(3);
        ListNode head2 = new ListNode(2);
        head1.next = head2;
        ListNode p = getIntersectionNode(null, head2);
        if (p != null) System.out.println(p.val);
    }

    public static void main(String[] args) {
        new IntersectionOfTwoLinkedLists().solution();
    }
}
