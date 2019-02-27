import common.Interval;

import java.util.*;

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
    public List<Interval> merge(List<Interval> intervals) {
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

    public static void main(String[] args) {
        List<Interval> ans = new MergeIntervals()
                .merge(Arrays.asList(
                        new Interval(1, 4),
                        new Interval(4, 5)));
        for (Interval v : ans) {
            System.out.println(v);
        }
    }
}
