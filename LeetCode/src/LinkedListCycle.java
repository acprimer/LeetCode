/**
 * Created by yao on 2014/11/28.
 */
public class LinkedListCycle {
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode p = head;
        ListNode q = head.next;
        while(q != null){
            if(p == q){
                return true;
            }
            p = p.next;
            q = q.next;
            if(q != null) q = q.next;
        }
        return false;
    }
}
