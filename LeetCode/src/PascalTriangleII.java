import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/16.
 *
 * LeetCode: Pascal's Triangle II
 * Link: https://oj.leetcode.com/problems/pascals-triangle-ii/
 * Description:
 * -----------------------------
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Could you optimize your algorithm to use only O(k) extra space?
 * -----------------------------
 *
 * Tag: Array
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> line = new ArrayList<Integer>();
        line.add(1);
        if(rowIndex <= 0) {
            return line;
        }
        long num = 1;
        int p = rowIndex, q = 1;
        for(int i=1;i<=rowIndex;i++) {
            num = num * p / q;
            p--; q++;
            line.add((int) num);
        }
        return line;
    }

    public static void main(String[] args) {
        List<Integer> line = new PascalTriangleII().getRow(30);
        for(int num : line) {
            System.out.println(num);
        }
    }
}
