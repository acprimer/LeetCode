import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yaodh on 2014/11/20.
 *
 * LeetCode: Subsets II
 * Link: https://oj.leetcode.com/problems/subsets-ii/
 * Description:
 * -----------------------------
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * ---Elements in a subset must be in non-descending order.
 * ---The solution set must not contain duplicate subsets.
 * -----------------------------
 *
 * Tag: Bit
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        ans.add(list);
        for(int i=0;i<num.length;i++) {
            int count = 1;
            while (i+1<num.length && num[i] == num[i+1]) {
                i++;
                count++;
            }
            int size = ans.size();
            for(int j=0;j<size;j++) {
                for(int k=1;k<=count;k++) {
                    List<Integer> newList = new ArrayList<Integer>(ans.get(j));
                    for(int p=0;p<k;p++) {
                        newList.add(num[i]);
                    }
                    ans.add(newList);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new SubsetsII().subsetsWithDup(new int[]{2, 2, 1});
        for(List<Integer> line : ans) {
            for(int x : line) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
