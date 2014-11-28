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
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private class NodeWithCmp implements Comparable<NodeWithCmp> {
        ListNode node;

        NodeWithCmp(ListNode a) {
            node = a;
        }

        @Override
        public int compareTo(NodeWithCmp o) {
            return node.val > o.node.val ? 1 : -1;
        }
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode head = new ListNode(0);
        Queue<NodeWithCmp> queue = new PriorityQueue<NodeWithCmp>();
        for (ListNode p : lists) {
            if (p != null) queue.offer(new NodeWithCmp(p));
        }
        ListNode pre = head;
        while (!queue.isEmpty()) {
            NodeWithCmp p = queue.poll();
            ListNode node = p.node;
            if (node.next != null) {
                queue.offer(new NodeWithCmp(node.next));
            }
            node.next = null;
            pre = pre.next = node;
        }
        return head.next;
    }

    public static void main(String[] args) {
        new MergeKSortedLists().solution();
    }

    public ListNode generate(int[] a) {
        ListNode head = new ListNode(a[0]);
        ListNode p = head;
        for (int i = 1; i < a.length; i++) {
            ListNode node = new ListNode(a[i]);
            p = p.next = node;
        }
        return head;
    }

    private void solution() {
        ListNode[] heads = new ListNode[4];
        heads[0] = generate(new int[]{1, 3, 4, 8});
        heads[1] = generate(new int[]{2, 5, 7, 8});
        heads[2] = generate(new int[]{2, 3, 9, 15});
        heads[3] = generate(new int[]{1, 7, 12, 16});
        List<ListNode> list = new ArrayList<ListNode>();
        list.add(heads[0]);
        list.add(heads[1]);
        list.add(heads[2]);
        list.add(heads[3]);
        ListNode p = mergeKLists(list);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }
}
