import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yaodh on 2014/11/27.
 * <p/>
 * LeetCode: Combination Sum
 * Link: https://oj.leetcode.com/problems/combination-sum/
 * Description:
 * -----------------------------
 * Given a set of candidate numbers (C) and a target number (T),
 * find all unique combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7,
 * A solution set is:
 * [7]
 * [2, 2, 3]
 * -----------------------------
 * <p/>
 * Tag: Backtracking
 */
public class CombinationSum {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, 0, target, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(int[] candidates, int start, int sum, int target, List<Integer> list) {
        if (sum == target) {
            ans.add(list);
            return;
        }
        if (start >= candidates.length || sum > target || sum + candidates[start] > target) {
            return;
        }
        List<Integer> preList = new ArrayList<Integer>(list);
        dfs(candidates, start + 1, sum, target, preList);
        while (sum <= target) {
            List<Integer> newList = new ArrayList<Integer>(preList);
            newList.add(candidates[start]);
            preList = newList;
            dfs(candidates, start + 1, sum += candidates[start], target, newList);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new CombinationSum().combinationSum(new int[]{1, 2, 3, 6, 7}, 7);
        for (List<Integer> line : ans) {
            for (int x : line) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
