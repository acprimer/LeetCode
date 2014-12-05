/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Climbing Stairs
 * Link: https://oj.leetcode.com/problems/climbing-stairs/
 * Description:
 * -----------------------------
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * -----------------------------
 * <p/>
 * Tag: Math
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int[] f = new int[n + 1];
        f[0] = f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        int ans = new ClimbingStairs().climbStairs(3);
        System.out.println(ans);
    }
}
