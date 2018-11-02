/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Sqrt(x)
 * Link: https://oj.leetcode.com/problems/sqrtx/
 * Description:
 * -----------------------------
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * -----------------------------
 * <p/>
 * Tag: Binary Search
 */
public class SqrtOfX {
    // 1. 使用long防止int溢出
//    public int sqrt(int x) {
//        if (x <= 1) return x;
//        // right = x; will be wrong.
//        int left = 1, right = x / 2;
//        while (left <= right) {
//            int mid = (left + right) >> 1;
//            long product = (long) mid * (long) mid;
//            if (product == x) return mid;
//            else if (product > x) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left - 1;
//    }

    // 2. 预设最大的边界为sqrt(Integer.MAX)
//    public int mySqrt(int x) {
//        if (x <= 1) return x;
//
//        int left = 1, right = Math.min(x / 2, (int) Math.sqrt(Integer.MAX_VALUE));
//        while (left < right) {
//            int mid = (left + right) >>> 1;
//            int mul = mid * mid;
//            int mul2 = (mid + 1) * (mid + 1);
//            if (mul <= x && mul2 > x) {
//                return mid;
//            }
//            if (mul > x) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//        return left;
//    }

    // 3. 利用除法代替乘法防止溢出
    public int mySqrt(int x) {
        if (x <= 1) return x;

        int left = 1, right = x / 2;
        while (left < right) {
            int mid = (left + right) >>> 1;
            int div = x / mid;
            if (mid <= div && mid + 1 > x / (mid + 1)) {
                return mid;
            }
            if (mid > div) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 4. 牛顿迭代法
//    public int mySqrt(int x) {
//        if (x <= 1) return x;
//
//        double ans = 1;
//        while (Math.abs(x - ans * ans) > 0.5) {
//            ans = (ans + x / ans) / 2;
//        }
//        return (int)ans;
//    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(i + " " + new SqrtOfX().mySqrt(i));
        }
        System.out.println(new SqrtOfX().mySqrt(2147395599));
        System.out.println(new SqrtOfX().mySqrt(2147483647));
        System.out.println(Math.sqrt(2147483647));
    }
}
