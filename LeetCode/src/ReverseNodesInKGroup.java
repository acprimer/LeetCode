import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/19.
 */
public class ReverseNodesInKGroup {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return head;
        ListNode copyHead = new ListNode(0);
        ListNode pre= copyHead, last = copyHead, backup = null;
        ListNode p = head;
        int count = 0;
        while(p != null) {
            ListNode node = new ListNode(p.val);
            if(count == 0) {
                pre = last;
                last = node;
                backup = p;
            }
            node.next = pre.next;
            pre.next = node;
            count = (count + 1) % k;
            p = p.next;
        }
        if(count > 0) {
            pre.next = backup;
        }
        return copyHead.next;
    }

    public void solution() {
        ListNode head = new ListNode(1);
        ListNode p = head;
        for(int i=2;i<=11;i++) {
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
        p = reverseKGroup(head, 3);
        while(p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
    public static void main(String[] args) {
        new ReverseNodesInKGroup().solution();
    }
}
