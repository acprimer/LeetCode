import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/16.
 *
 * LeetCode: Triangle
 * Link: https://oj.leetcode.com/problems/triangle/
 * Description:
 * -----------------------------
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * -----------------------------
 *
 * Tag: Dynamic Programming
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() <= 0) {
            return 0;
        }
        int size = triangle.size();
        int[] dp = new int[size];
        int pre = 0;
        dp[0] = triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++) {
            pre = dp[i] = Integer.MAX_VALUE;
            for(int j=0;j<triangle.get(i).size();j++) {
                int x = triangle.get(i).get(j);
                int tmp = dp[j];
                dp[j] = x + Math.min(dp[j], pre);
                pre = tmp;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<triangle.size();i++) {
            ans = Math.min(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> line = new ArrayList<Integer>();
        line.add(2);
        triangle.add(line);
        line = new ArrayList<Integer>();
        line.add(3);
        line.add(4);
        triangle.add(line);
        line = new ArrayList<Integer>();
        line.add(6);
        line.add(5);
        line.add(7);
        triangle.add(line);
        line = new ArrayList<Integer>();
        line.add(4);
        line.add(1);
        line.add(8);
        line.add(3);
        triangle.add(line);
        int ans = new Triangle().minimumTotal(triangle);
        System.out.println(ans);
    }
}
