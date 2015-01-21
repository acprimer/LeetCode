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
    // O(m+n) space
//    public void setZeroes(int[][] matrix) {
//        if (matrix == null || matrix.length <= 0) return;
//        int row = matrix.length;
//        int column = matrix[0].length;
//        boolean[] zeroRows = new boolean[row];
//        boolean[] zeroColumns = new boolean[column];
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < column; j++) {
//                if (matrix[i][j] == 0) {
//                    zeroRows[i] = true;
//                    zeroColumns[j] = true;
//                }
//            }
//        }
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < column; j++) {
//                if (zeroRows[i] || zeroColumns[j]) {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//    }

    // O(1) space
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) return;
        int row = -1, col = -1;
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    if (row == -1) {
                        row = i;
                        col = j;
                    } else {
                        matrix[row][j] = matrix[i][col] = 0;
                    }
                }
            }
        }
        if (row == -1) {
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i != row && j != col && (matrix[row][j] == 0 || matrix[i][col] == 0)) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            matrix[i][col] = 0;
        }
        for (int i = 0; i < m; i++) {
            matrix[row][i] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 0, 2}, {1, 1, 1}, {0, 1, 1}};
        new SetMatrixZeroes().setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
