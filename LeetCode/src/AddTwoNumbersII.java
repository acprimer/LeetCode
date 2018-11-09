/**
 * Created by yaodh on 2018/11/8.
 */
public class AddTwoNumbersII {
    // 不反转链表
    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {
        ListNode p = L1, q = L2;
        int len1 = 0, len2 = 0;
        while (p != null) {
            len1++;
            p = p.next;
        }
        while (q != null) {
            len2++;
            q = q.next;
        }
        ListNode dump = new ListNode(0);
        p = L1;
        q = L2;
        ListNode r = dump;
        for (int i = Math.max(len1, len2); i > 0; i--) {
            int sum = 0;
            if (i == len1) {
                len1--;
                sum += p.val;
                p = p.next;
            }
            if (i == len2) {
                len2--;
                sum += q.val;
                q = q.next;
            }
            r.next = new ListNode(sum);
            r = r.next;
        }
        return flatten(dump);
    }

    private ListNode flatten(ListNode dump) {
        boolean carry = true;
        while (carry) {
            ListNode p = dump;
            carry = false;
            while (p.next != null) {
                if (p.next.val >= 10) {
                    p.next.val %= 10;
                    p.val++;
                    if (p.val >= 10) carry = true;
                }
                p = p.next;
            }
        }
        if (dump.val > 0) return dump;
        else return dump.next;
    }

    // 反转链表
//    public ListNode addTwoNumbers(ListNode L1, ListNode L2) {
//        ListNode p = reverse(L1);
//        ListNode q = reverse(L2);
//        ListNode ans = new ListNode(0);
//        ListNode m = ans;
//        int carry = 0;
//        while (p != null || q != null) {
//            int sum = carry;
//            if (p != null) {
//                sum += p.val;
//                p = p.next;
//            }
//            if (q != null) {
//                sum += q.val;
//                q = q.next;
//            }
//            carry = sum / 10;
//            m.next = new ListNode(sum % 10);
//            m = m.next;
//        }
//        if (carry > 0) m.next = new ListNode(carry);
//        return reverse(ans.next);
//    }
//
//    private ListNode reverse(ListNode head) {
//        ListNode dump = new ListNode(0);
//        while (head != null) {
//            ListNode next = head.next;
//            head.next = dump.next;
//            dump.next = head;
//            head = next;
//        }
//        return dump.next;
//    }

    public static void main(String[] args) {
        ListNode.print(new AddTwoNumbersII().addTwoNumbers(
                ListNode.generate(9, 9,9), ListNode.generate(2)));
    }
}
