import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] ans = new int[9][9];
        ans[4][4] = m;
        for (int i = 0; i < n; i++) {
            update(ans);
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println(ans[i][8]);
        }
    }

    private static void update(int[][] ans) {
        int[][] target = new int[9][9];
        int[][] dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                target[i][j] += ans[i][j] * 2;
                for (int k = 0; k < dir.length; k++) {
                    int x = i + dir[k][0];
                    int y = i + dir[k][1];
                    if (x >= 0 && x < 9 && y >= 0 && y < 9) {
                        target[x][y] += ans[i][j];
                    }
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                ans[i][j] = target[i][j];
            }
        }
    }
}
