import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/19.
 *
 * LeetCode: Insert common.Interval
 * Link: https://oj.leetcode.com/problems/insert-interval/
 * Description:
 * -----------------------------
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * -----------------------------
 *
 * Tag: Array
 */
public class InsertInterval {
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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int startIndex = findInterval(intervals, newInterval.start);
        int endIndex = findInterval(intervals, newInterval.end);
        if(startIndex == endIndex) {
            if(startIndex % 2 != 0) {
                intervals.add((startIndex + 1) / 2, newInterval);
            }
            return intervals;
        }
        startIndex = (startIndex + 1) / 2;
        endIndex = endIndex / 2;
        intervals.get(startIndex).start = Math.min(intervals.get(startIndex).start, newInterval.start);
        intervals.get(startIndex).end = Math.max(intervals.get(endIndex).end, newInterval.end);
        for(int i=startIndex;i<endIndex;i++) {
            intervals.remove(startIndex+1);
        }
        return intervals;
    }

    private int findInterval(List<Interval> intervals, int x) {
        if(intervals.size() <= 0 || x < intervals.get(0).start) return -1;
        int idx = 0;
        while(idx < intervals.size() && x > intervals.get(idx).end) {
            idx++;
        }
        if(idx >= intervals.size() || x < intervals.get(idx).start) return idx*2-1;
        return idx*2;
    }

    public void solution() {
        List<Interval> intervals = new ArrayList<Interval>();
//        intervals.add(new common.Interval(1,3));
//        intervals.add(new common.Interval(6,9));
//        intervals.add(new common.Interval(16,19));
        intervals = new InsertInterval().insert(intervals, new Interval(2,8));
        for(Interval xy : intervals) {
            System.out.println(xy.start + " " + xy.end);
        }
    }

    public static void main(String[] args) {
        new InsertInterval().solution();
    }
}
