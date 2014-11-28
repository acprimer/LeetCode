import java.util.Stack;

/**
 * Created by yao on 2014/11/27.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height.length <= 1) return 0;
        int ans = 0;
        int first = 0, last = height.length - 1;
        while (first < last) {
            if (height[first] < height[last]) {
                ans = Math.max(ans, height[first] * (last - first));
                int h = height[first];
                while (first < last && height[first] <= h) {
                    first++;
                }
            } else {
                ans = Math.max(ans, height[last] * (last - first));
                int h = height[last];
                while (first < last && height[last] <= h) {
                    last--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new ContainerWithMostWater().maxArea(new int[]{4, 3, 2, 1});
        System.out.println(ans);
    }
}
