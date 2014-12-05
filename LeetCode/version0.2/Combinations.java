import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/13.
 * <p/>
 * LeetCode: Combinations
 * Link: https://oj.leetcode.com/problems/combinations/
 * Description:
 * -----------------------------
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 * -----------------------------
 * <p/>
 * Tag: Hash DFS
 */
public class Combinations {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<Integer>();
        dfs(1, k, n, k, list);
        return ans;
    }

    // combination of left numbers from [start...n]
    private void dfs(int start, int left, int n, int k, List<Integer> list) {
        // we have choose k integers, then put the list to answer and return.
        if (left <= 0) {
            ans.add(list);
            return;
        }
        for (int i = start; i <= n + 1 - left; i++) {
            List<Integer> newList = new ArrayList<Integer>(list);
            newList.add(i);
            dfs(i + 1, left - 1, n, k, newList);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new Combinations().combine(4, 2);
        for (List<Integer> line : ans) {
            for (int x : line) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
