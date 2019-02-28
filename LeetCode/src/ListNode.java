/**
 * Created by yaodh on 2018/11/8.
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode generate(int... nums) {
        ListNode p = new ListNode(0);
        ListNode head = p;
        for (int x : nums) {
            p.next = new ListNode(x);
            p = p.next;
        }
        return head.next;
    }

    public static void print(ListNode head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public void print() {
        ListNode p = this;
        while (p != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println();
    }
}
