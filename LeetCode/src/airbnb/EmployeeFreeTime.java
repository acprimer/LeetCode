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

    private List<Interval> merge(List<List<Interval>> avails) {
        List<Interval> intervals = new ArrayList<>();
        for (List<Interval> v : avails) {
            intervals.addAll(v);
        }
        return mergeIntervals(intervals);
    }

    public List<Interval> mergeIntervals(List<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        List<Interval> ans = new ArrayList<>();
        for (Interval v : intervals) {
            Interval u;
            if (ans.size() == 0 || (u = ans.get(ans.size() - 1)).end < v.start) {
                ans.add(v);
            } else {
                u.end = Math.max(u.end, v.end);
            }
        }
        return ans;
    }
}
