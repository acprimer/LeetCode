/**
 * Created by yaodh on 2014/11/22.
 * <p/>
 * LeetCode: Maximal Rectangle
 * Link: https://oj.leetcode.com/problems/maximal-rectangle/
 * Description:
 * -----------------------------
 * Given a 2D binary matrix filled with 0's and 1's,
 * find the largest rectangle containing all ones and return its area.
 * -----------------------------
 * <p/>
 * Tag: Stack
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length <=0) return 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];
        for(int j=0;j<column;j++) dp[0][j] = matrix[0][j] - '0';
        for(int i=1;i<row;i++) {
            for(int j=0;j<column;j++) {
                dp[i][j] = (matrix[i][j] == '0' ? 0 : 1 + dp[i-1][j]);
            }
        }
        int ans = 0;
        for(int i=0;i<row;i++) {
            ans = Math.max(ans, largestRectangleArea(dp[i]));
        }
        return ans;
    }

    public int largestRectangleArea(int[] height) {
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
    }

    public static void main(String[] args) {
        char[][] matrix = new char[4][4];
        matrix[0] = "0011".toCharArray();
        matrix[1] = "0011".toCharArray();
        matrix[2] = "0111".toCharArray();
        matrix[3] = "0111".toCharArray();
        int ans = new MaximalRectangle().maximalRectangle(matrix);
        System.out.println(ans);
    }
}
