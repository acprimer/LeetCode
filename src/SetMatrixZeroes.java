/**
 * Created by yaodh on 2014/11/22.
 * <p/>
 * LeetCode: Set Matrix Zeroes
 * Link: https://oj.leetcode.com/problems/set-matrix-zeroes/
 * Description:
 * -----------------------------
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * -----------------------------
 * <p/>
 * Tag: Array
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) return;
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[] zeroRows = new boolean[row];
        boolean[] zeroColumns = new boolean[column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroColumns[j] = true;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (zeroRows[i] || zeroColumns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
