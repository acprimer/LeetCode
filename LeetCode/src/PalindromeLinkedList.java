/**
 * Created by yaodh on 2018/11/9.
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = reverse(slow.next);
        slow.next = null;
        slow = head;
        while (fast != null && slow != null) {
            if (fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode dump = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = dump.next;
            dump.next = head;
            head = next;
        }
        return dump.next;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeLinkedList().isPalindrome(ListNode.generate(1,2,1,1,2,1)));
    }
}
