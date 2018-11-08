/**
 * Created by yaodh on 2018/11/8.
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        ListNode p = reverse(L1);
        ListNode q = reverse(L2);
        ListNode ans = new ListNode(0);
        ListNode m = ans;
        int carry = 0;
        while (p != null || q != null) {
            int sum = carry;
            if (p != null) {
                sum += p.val;
                p = p.next;
            }
            if (q != null) {
                sum += q.val;
                q = q.next;
            }
            carry = sum / 10;
            m.next = new ListNode(sum % 10);
            m = m.next;
        }
        if (carry > 0) m.next = new ListNode(carry);
        return reverse(ans.next);
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
        ListNode.print(new AddTwoNumbersII().addTwoNumbers(
                ListNode.generate(7,2,4,3), ListNode.generate(5,6,4)));
    }
}
