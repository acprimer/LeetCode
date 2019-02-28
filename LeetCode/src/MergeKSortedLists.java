import java.util.*;

/**
 * Created by yaodh on 2014/11/28.
 * <p/>
 * LeetCode: Merge k Sorted Lists
 * Link: https://oj.leetcode.com/problems/merge-k-sorted-lists/
 * Description:
 * -----------------------------
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * -----------------------------
 * <p/>
 * Tag: Heap
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        // 每个链表的头结点入队
        for (ListNode p : lists) {
            if (p != null) queue.offer(p);
        }
        ListNode pre = head;
        while (!queue.isEmpty()) {
            ListNode p = queue.poll();
            if (p.next != null) {
                queue.offer(p.next);
            }
            p.next = null;
            pre = pre.next = p;
        }
        return head.next;
    }

    public static void main(String[] args) {
        new MergeKSortedLists().mergeKLists(
                new ListNode[]{
                        ListNode.generate(1, 3, 4, 8),
                        ListNode.generate(2, 5, 7, 8),
                        ListNode.generate(2, 3, 9, 15),
                        ListNode.generate(1, 7, 12, 16)
                }
        ).print();
    }
}
