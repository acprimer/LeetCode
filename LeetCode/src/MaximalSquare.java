import java.util.Stack;

/**
 * Created by yaodh on 15/8/2.
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(matrix[i][j] == '0') {
                    continue;
                }
                if(i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans * ans;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'}};
        System.out.println(new MaximalSquare().maximalSquare(matrix));
    }
}
