import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/16.
 *
 * LeetCode: Pascal's Triangle
 * Link: https://oj.leetcode.com/problems/pascals-triangle/
 * Description:
 * -----------------------------
 * Given numRows, generate the first numRows of Pascal's triangle.
 * -----------------------------
 *
 * Tag: Array
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        if(numRows <= 0) {
            return triangle;
        }
        List<Integer> line1 = new ArrayList<Integer>();
        line1.add(1);
        triangle.add(line1);
        for(int i=1;i<numRows;i++) {
            List<Integer> line = new ArrayList<Integer>();
            line.add(1);
            for(int j=1;j<i;j++) {
                line.add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
            }
            line.add(1);
            triangle.add(line);
        }
        return triangle;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new PascalTriangle().generate(3);
        for(List<Integer> line : triangle) {
            for(Integer num : line) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
