package lintcode;

public class P363 {
    public int trapRainWater(int[] heights) {
        if (heights == null || heights.length == 0) return 0;

        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = heights[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(heights[i], left[i - 1]);
        }
        right[n - 1] = heights[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(heights[i], right[i + 1]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.min(left[i], right[i]) - heights[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new P363().trapRainWater(new int[]{
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        }));
    }
}
