import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by yaodh on 15/7/28.
 */
public class SlidingWindowMaximum {
    class Interval implements Comparable<Interval> {
        int val;
        int idx;

        public Interval(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Interval interval) {
            return this.val < interval.val ? 1 : -1;
        }
    }

    // PriorityQueue O(n*lgk)
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        if (nums == null || nums.length == 0) {
//            return new int[]{};
//        }
//        int[] ans = new int[nums.length - k + 1];
//        PriorityQueue<common.Interval> queue = new PriorityQueue<common.Interval>();
//        common.Interval[] intervals = new common.Interval[nums.length];
//        for (int i = 0; i < k; i++) {
//            queue.offer(intervals[i] = new common.Interval(nums[i], i));
//        }
//        ans[0] = queue.peek().val;
//        for (int i = k; i < nums.length; i++) {
//            queue.remove(intervals[i - k]);
//            queue.offer(intervals[i] = new common.Interval(nums[i], i));
//            ans[i - k + 1] = queue.peek().val;
//        }
//        return ans;
//    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int[] queue = new int[nums.length];
        int head = -1, tail = 0;
        int[] ans = new int[nums.length - k + 1];
//        int max =
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = new SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println(Arrays.toString(ans));
    }
}
