import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/20.
 *
 * LeetCode: Gray Code
 * Link: https://oj.leetcode.com/problems/gray-code/
 * Description:
 * -----------------------------
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code,
 * print the sequence of gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0   01 - 1   11 - 3   10 - 2
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * -----------------------------
 *
 * Tag: Backtracing
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<Integer>();
        ans.add(0);
        if(n == 0) return ans;
        ans.add(1);
        int pow = 1;
        for(int i=1;i<n;i++) {
            pow <<= 1;
            int size = ans.size();
            for(int j=size-1;j>=0;j--) {
                ans.add(pow + ans.get(j));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> ans = new GrayCode().grayCode(3);
        for(int x : ans) {
            System.out.println(x);
        }
    }
}
