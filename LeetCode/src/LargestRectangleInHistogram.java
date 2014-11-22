/**
 * Created by yaodh on 2014/11/22.
 * <p/>
 * LeetCode: Largest Rectangle in Histogram
 * Link: https://oj.leetcode.com/problems/largest-rectangle-in-histogram/
 * Description:
 * -----------------------------
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 * -----------------------------
 * <p/>
 * Tag: Stack
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length <= 0) return 0;
        int size = height.length;
        int[] minHeigh = new int[size];
        int[] idx = new int[size];
        int count = -1;
        int ans = 0;
        for (int i = 0; i <= size; i++) {
            int curHeight = 0;
            if (i < size) curHeight = height[i];
            if (count >= 0 && curHeight == minHeigh[count]) {
                continue;
            }
            if (count == -1 || curHeight >= minHeigh[count]) {
                minHeigh[++count] = curHeight;
                idx[count] = i;
            } else {
                while (count >= 0) {
                    if (curHeight < minHeigh[count]) {
                        ans = Math.max(ans, minHeigh[count] * (i - idx[count]));
                        count--;
                    } else break;
                }
                minHeigh[++count] = curHeight;
                // Attention: we do not update idx[count]
                // idx[count] = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new LargestRectangleInHistogram().largestRectangleArea(new int[]{2, 1, 2});
        System.out.println(ans);
    }
}
