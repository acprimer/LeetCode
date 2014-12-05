import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Permutations
 * Link: https://oj.leetcode.com/problems/permutations/
 * Description:
 * -----------------------------
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * -----------------------------
 * <p/>
 * Tag: Backtracking
 */
public class Permutations {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> permute(int[] num) {
        dfs(num, 0, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(int[] num, int start, List<Integer> list) {
        if (start >= num.length) {
            ans.add(list);
            return;
        }
        for (int i = start; i < num.length; i++) {
            swap(num, i, start);
            List<Integer> newList = new ArrayList<Integer>(list);
            newList.add(num[start]);
            dfs(num, start + 1, newList);
            swap(num, i, start);
        }
    }

    public void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new Permutations().permute(new int[]{1, 2, 3});
        for (List<Integer> line : ans) {
            for (int x : line) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
