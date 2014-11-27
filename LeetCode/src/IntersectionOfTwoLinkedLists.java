import java.util.HashSet;
import java.util.Set;

/**
 * Created by yao on 2014/11/27.
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
        Set<ListNode> set = new HashSet<ListNode>();
        ListNode p = headA, q = headB;
        while (p != null || q != null) {
            if (p != null) {
                if (set.contains(p)) return p;
                set.add(p);
                p = p.next;
            }
            if (q != null) {
                if (set.contains(q)) return q;
                set.add(q);
                q = q.next;
            }
        }
        return null;
    }

    public void solution() {
        ListNode head1 = new ListNode(3);
//        int[] a = new int[]{2, 4, 6};
//        ListNode p = head1;
//        for (int i = 0; i < a.length; i++) {
//            ListNode node = new ListNode(a[i]);
//            p.next = node;
//            p = node;
//        }
        ListNode head2 = new ListNode(2);
        head2.next = head1;
//        int[] b = new int[]{1, 3, 5};
//        p = head2;
//        for (int i = 0; i < b.length; i++) {
//            ListNode node = new ListNode(b[i]);
//            p.next = node;
//            p = node;
//        }
        ListNode p = getIntersectionNode(head1, head2);
        if (p != null) System.out.println(p.val);
    }

    public static void main(String[] args) {
        new IntersectionOfTwoLinkedLists().solution();
    }
}
