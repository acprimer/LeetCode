import java.util.*;

/**
 * Created by yaodh on 2015/4/22.
 * <p/>
 * LeetCode: Happy Number
 * Link: https://leetcode.com/problems/happy-number/
 * Description:
 * -----------------------------
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * Example: 19 is a happy number
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * -----------------------------
 * <p/>
 * Tag: Hash
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (n != 1) {
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
            n = fun(n);
        }
        return true;
    }

    //    public int reorder(int n) {
//        if(n == 0) return 0;
//        StringBuilder builder = new StringBuilder();
//        while(n != 0) {
//            if(n % 10 != 0) {
//                builder.append((char)(n % 10 + '0'));
//            }
//            n /= 10;
//        }
//        char[] chs = builder.toString().toCharArray();
//        Arrays.sort(chs);
//        return Integer.parseInt(String.valueOf(chs));
//    }
    public int fun(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (n % 10) * (n % 10);
            n /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        boolean ans = new HappyNumber().isHappy(100);
        System.out.println(ans);
    }
}
