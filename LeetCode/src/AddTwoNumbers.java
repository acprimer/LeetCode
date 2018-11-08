/**
 * Created by yaodh on 2018/11/8.
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        ListNode p = L1;
        ListNode q = L2;
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
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode.print(new AddTwoNumbers().addTwoNumbers(
                ListNode.generate(1,8), ListNode.generate(0)));
    }
}
