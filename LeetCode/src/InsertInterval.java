import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/19.
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
//        intervals.add(new Interval(1,3));
//        intervals.add(new Interval(6,9));
//        intervals.add(new Interval(16,19));
        intervals = new InsertInterval().insert(intervals, new Interval(2,8));
        for(Interval xy : intervals) {
            System.out.println(xy.start + " " + xy.end);
        }
    }

    public static void main(String[] args) {
        new InsertInterval().solution();
    }
}
