/**
 * Created by yaodh on 2018/4/13.
 */
public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        double area = 0.0f;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    area = Math.max(area, cal(points[i], points[j], points[k]));
                }
            }
        }
        return area;
    }

    private double cal(int[] x, int[] y, int[] z) {
        double a = dist(x, y);
        double b = dist(x, z);
        double c = dist(y, z);
        double p = (a + b + c) / 2;
        if ((p-a) < 1e-6) return 0.0;
        if ((p-b) < 1e-6) return 0.0;
        if ((p-c) < 1e-6) return 0.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    private double dist(int[] x, int[] y) {
        return Math.sqrt((x[0] - y[0]) * (x[0] - y[0]) + (x[1] - y[1]) * (x[1] - y[1]));
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{35,-23},{-12,-48},{-34,-40},{21,-25},{-35,-44},{24,1},{16,-9},{41,4},{-36,-49},{42,-49},{-37,-20},{-35,11},{-2,-36},{18,21},{18,8},{-24,14},{-23,-11},{-8,44},{-19,-3},{0,-10},{-21,-4},{23,18},{20,11},{-42,24},{6,-19}};
        System.out.println(new LargestTriangleArea().largestTriangleArea(points));
    }
}
