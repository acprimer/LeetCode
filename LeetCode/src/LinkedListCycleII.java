/**
 * Created by yao on 2014/11/28.
 */
public class LinkedListCycleII {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
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
        ListNode head = new ListNode(1);
        ListNode node = new ListNode(2);
        head.next = node;
        node.next = node;
        head = detectCycle(head);
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        new LinkedListCycleII().solution();
    }
}
