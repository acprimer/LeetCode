/**
 * Created by yao on 2014/11/23.
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int x = 0, y = -1, k = 0, count = n, curNumber = 1;
        int visRows = 0, visColumns = 0;
        for (int i = 0; i < n * n; i++) {
            x += directions[k][0];
            y += directions[k][1];
            matrix[x][y] = curNumber++;
            if (--count == 0) {
                if (k % 2 == 0) visRows++;
                else visColumns++;
                k = (k + 1) % 4;
                if (k % 2 == 0) count = n - visColumns;
                else count = n - visRows;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new SpiralMatrixII().generateMatrix(0);
        for(int[] line : matrix) {
            for(int x : line) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
