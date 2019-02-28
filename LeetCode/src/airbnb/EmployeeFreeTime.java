package airbnb;

import common.Interval;

import java.util.*;

/**
 * Weare given a list schedule of employees, which represents the working time foreach employee.
 * <p>
 * Eachemployee has a list of non-overlapping Intervals, and these intervals are in sortedorder.
 * <p>
 * Returnthe list of finite intervals representing common, positive-length freetime for all employees, also in sorted order.
 * <p>
 * Input: schedule =[[[1,2],[5,6]],[[1,3]],[[4,10]]]
 * Output: [[3,4]]
 */
public class EmployeeFreeTime {
    public static void main(String[] args) {
        List<List<Interval>> list = new ArrayList<>();
        list.add(Arrays.asList(new Interval(1, 3), new Interval(6, 7)));
        list.add(Arrays.asList(new Interval(2, 4)));
        list.add(Arrays.asList(new Interval(2, 5), new Interval(9, 12)));
        List<Interval> ans = new EmployeeFreeTime().employeeFreeTime(list);
        for (Interval v : ans) {
            System.out.println(v);
        }
    }

    // 参照 Merge K Sorted List
    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> merged = merge(avails);

        List<Interval> ans = new ArrayList<>();
        if (merged.size() <= 1) return ans;
        for (int i = 1; i < merged.size(); i++) {
            int start = merged.get(i - 1).end;
            int end = merged.get(i).start;
            ans.add(new Interval(start, end));
        }

        return ans;
    }

    private class IntervalNode {
        Interval val;
        IntervalNode next;

        public IntervalNode(Interval val, IntervalNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private List<Interval> merge(List<List<Interval>> avails) {
        Queue<IntervalNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val.start));
        for (int i = 0; i < avails.size(); i++) {
            List<Interval> v = avails.get(i);
            if (v == null || v.isEmpty()) continue;
            IntervalNode p = new IntervalNode(v.get(0), null);
            queue.offer(p);
            for (int j = 1; j < v.size(); j++) {
                IntervalNode node = new IntervalNode(v.get(j), null);
                p.next = node;
                p = node;
            }
        }
        List<Interval> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            IntervalNode p = queue.poll();
            if (p.next != null) queue.offer(p.next);
            Interval last;
            if (ans.size() == 0 || p.val.start > (last = ans.get(ans.size() - 1)).end) {
                ans.add(p.val);
            } else if (p.val.end > last.end) {
                last.end = p.val.end;
            }
        }
        return ans;
    }
}
