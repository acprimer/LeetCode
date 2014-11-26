import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yaodh on 2014/11/27.
 * <p/>
 * LeetCode: Combination Sum II
 * Link: https://oj.leetcode.com/problems/combination-sum-ii/
 * Description:
 * -----------------------------
 * Given a collection of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8,
 * A solution set is:
 * [1, 7]
 * [1, 2, 5]
 * [2, 6]
 * [1, 1, 6]
 * -----------------------------
 * <p/>
 * Tag: Backtracking
 */
public class CombinationSumII {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum2(int[] num, int target) {
        Arrays.sort(num);
        dfs(num, 0, 0, target, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(int[] num, int start, int sum, int target, List<Integer> list) {
        if (sum == target) {
            ans.add(list);
            return;
        }
        if (start >= num.length || sum > target || sum + num[start] > target) {
            return;
        }
        int j = start;
        while (j < num.length && num[j] == num[start]) {
            j++;
        }
        List<Integer> preList = new ArrayList<Integer>(list);
        dfs(num, j, sum, target, preList);
        for (int i = start; i < j; i++) {
            List<Integer> newList = new ArrayList<Integer>(preList);
            newList.add(num[start]);
            preList = newList;
            dfs(num, j, sum += num[start], target, newList);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new CombinationSumII().combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> line : ans) {
            for (int x : line) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
