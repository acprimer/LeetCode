/**
 * Created by yaodh on 2014/11/25.
 * <p/>
 * LeetCode: Trapping Rain Water
 * Link: https://oj.leetcode.com/problems/trapping-rain-water/
 * Description:
 * -----------------------------
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * -----------------------------
 * <p/>
 * Tag: Binary Search
 */
public class TrappingRainWater {
    public int trap(int[] A) {
        if (A.length <= 1) return 0;
        int ans = 0;
        int p = 1, q = A.length - 2;
        while (p < A.length && A[p] >= A[p - 1]) {
            p++;
        }
        while (q >= 0 && A[q] >= A[q + 1]) {
            q--;
        }
        p--;
        q++;
        int sum = 0;
        for (int i = p + 1; i < q; i++) {
            int minHeight = Math.min(A[p], A[q]);
            if (A[i] <= minHeight) {
                sum += A[i];
            } else {
                ans += (i - p - 1) * Math.min(A[p], A[i]) - sum;
                sum = 0;
                p = i;
            }
        }
        if (q - p > 1) ans += (q - p - 1) * Math.min(A[p], A[q]) - sum;
        return ans;
    }

    public static void main(String[] args) {
        int ans = new TrappingRainWater().trap(new int[]{6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3});
        System.out.println(ans);
    }
}
// 5,2,1,2,1,5 14
// 5,4,1,2  1
// 0,2,0 0
// 6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3 -->83