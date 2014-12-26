import java.util.Stack;

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
        int ans = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <= height.length; i++) {
            int curHeight = 0;
            if (i < height.length) {
                curHeight = height[i];
            }
            if (stack.isEmpty() || curHeight > height[stack.peek()]) {
                stack.push(i);
                continue;
            }
            if (curHeight < height[stack.peek()]) {
                int lastIndex = i;
                while (!stack.isEmpty() && curHeight < height[stack.peek()]) {
                    ans = Math.max(ans, height[stack.peek()] * (i - stack.peek()));
                    lastIndex = stack.pop();
                }
                height[lastIndex] = curHeight;
                stack.push(lastIndex);
            }
        }
        return ans;
    }

    // record the count of heights form index of the minimum height to current index
    /*public int largestRectangleArea(int[] height) {
        if (height == null || height.length <= 0) return 0;
        int size = height.length;
        int[] minHeigh = new int[size];
        int[] count = new int[size];
        int top = -1;
        int ans = 0;
        for (int i = 0; i <= size; i++) {
            int curHeight = 0;
            if (i < size) curHeight = height[i];
            if (top >= 0 && curHeight == minHeigh[top]) {
                count[top]++;
                continue;
            }
            if (top == -1 || curHeight > minHeigh[top]) {
                minHeigh[++top] = curHeight;
                count[top] = 1;
            } else {
                int total = 0;
                while (top >= 0) {
                    if (curHeight < minHeigh[top]) {
                        total += count[top];
                        ans = Math.max(ans, minHeigh[top] * total);
                        top--;
                    } else break;
                }
                minHeigh[++top] = curHeight;
                count[top] = total + 1;
            }
        }
        return ans;
    }*/

    public static void main(String[] args) {
        int ans = new LargestRectangleInHistogram().largestRectangleArea(new int[]{1, 1});
        System.out.println(ans);
    }
    /*
    // record the index of the minimum height
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
                    }
                    else break;
                }
                minHeigh[++count] = curHeight;
                // Attention: we do not update idx[count]
                // idx[count] = i;
            }
        }
        return ans;
    }
    */
}
