import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yaodh on 2014/11/20.
 *
 * LeetCode: Subsets
 * Link: https://oj.leetcode.com/problems/subsets/
 * Description:
 * -----------------------------
 * Given a set of distinct integers, S, return all possible subsets.
 * ---Elements in a subset must be in non-descending order.
 * ---The solution set must not contain duplicate subsets.
 * -----------------------------
 *
 * Tag: Bit
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        ans.add(list);
        for(int i=0;i<S.length;i++) {
            int size = ans.size();
            for(int j=0;j<size;j++) {
                List<Integer> newList = new ArrayList<Integer>(ans.get(j));
                newList.add(S[i]);
                ans.add(newList);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new Subsets().subsets(new int[]{3,4,1});
        for(List<Integer> line : ans) {
            for(int x : line) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
