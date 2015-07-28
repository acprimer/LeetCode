/**
 * Created by yaodh on 2015/7/28.
 */
public class ReverseLinkedList {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode reverseList(ListNode head) {
        ListNode dumb = new ListNode(0);
        while(head != null) {
            ListNode p = head.next;
            head.next = dumb.next;
            dumb.next = head;
            head = p;
        }
        return dumb.next;
    }
}
