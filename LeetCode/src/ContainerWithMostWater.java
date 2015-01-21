/**
 * Created by yaodh on 2014/11/27.
 * <p/>
 * LeetCode: Container With Most Water
 * Link: https://oj.leetcode.com/problems/container-with-most-water/
 * Description:
 * -----------------------------
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines,which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 * -----------------------------
 * <p/>
 * Tag: TwoPointers
 */
public class ContainerWithMostWater {
//    public int maxArea(int[] height) {
//        if (height.length <= 1) return 0;
//        int ans = 0;
//        int first = 0, last = height.length - 1;
//        while (first < last) {
//            if (height[first] < height[last]) {
//                ans = Math.max(ans, height[first] * (last - first));
//                int h = height[first];
//                while (first < last && height[first] <= h) {
//                    first++;
//                }
//            } else {
//                ans = Math.max(ans, height[last] * (last - first));
//                int h = height[last];
//                while (first < last && height[last] <= h) {
//                    last--;
//                }
//            }
//        }
//        return ans;
//    }

    public int maxArea(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            ans = Math.max(ans, (right - left) * h);
            while (left < right && height[left] <= h) {
                left++;
            }
            while (left < right && height[right] <= h) {
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new ContainerWithMostWater().maxArea(new int[]{4, 3, 2, 1});
        System.out.println(ans);
    }
}
