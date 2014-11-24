import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Merge Intervals
 * Link: https://oj.leetcode.com/problems/merge-intervals/
 * Description:
 * -----------------------------
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * -----------------------------
 * <p/>
 * Tag: Greedy
 */
public class MergeIntervals {
    class Interval {
        int start, end;

        Interval() {
            start = end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    class IntervalCmp implements Comparable<IntervalCmp> {
        int start, end;

        IntervalCmp(int s, int e) {
            start = s;
            end = e;
        }

        @Override
        public int compareTo(IntervalCmp o) {
            return Integer.valueOf(start).compareTo(Integer.valueOf(o.start));
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        List<IntervalCmp> list = new ArrayList<IntervalCmp>();
        for (Interval interval : intervals) {
            list.add(new IntervalCmp(interval.start, interval.end));
        }
        Collections.sort(list);
        int largest = list.get(0).end;
        int count = 1;
        intervals.get(0).start = list.get(0).start;
        intervals.get(0).end = list.get(0).end;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start <= largest) {
                largest = Math.max(largest, list.get(i).end);
                intervals.get(count).end = largest;
            } else {
                intervals.get(count - 1).end = largest;
                intervals.get(count++).start = list.get(i).start;
                largest = list.get(i).end;
            }
        }
        intervals.get(count - 1).end = largest;
        for (int i = intervals.size() - count; i > 0; i--) {
            intervals.remove(count);
        }
        return intervals;
    }

    public void solution() {
        int[] start = new int[]{};
        int[] end = new int[]{};
        List<Interval> list = new ArrayList<Interval>();
        for (int i = 0; i < start.length; i++) {
            list.add(new Interval(start[i], end[i]));
        }
        list = merge(list);
        for (Interval interval : list) {
            System.out.println(interval.start + " " + interval.end);
        }
    }

    public static void main(String[] args) {
        new MergeIntervals().solution();
    }
}
