import java.util.*;

/**
 * Created by yaodh on 2014/11/23.
 * <p/>
 * LeetCode: Permutations II
 * Link: https://oj.leetcode.com/problems/permutations-ii/
 * Description:
 * -----------------------------
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * -----------------------------
 * <p/>
 * Tag: Backtracking Hash
 */
public class PermutationsII {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> permuteUnique(int[] num) {
        dfs(num, 0, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(int[] num, int start, List<Integer> list) {
        if (start >= num.length) {
            ans.add(list);
            return;
        }
        Set<Integer> set = new HashSet<Integer>();
        for (int i = start; i < num.length; i++) {
            if (set.contains(num[i])) continue;
            set.add(num[i]);
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
        List<List<Integer>> ans = new PermutationsII().permuteUnique(new int[]{1, 2, 1, 1});
        System.out.println(ans.size());
        for (List<Integer> line : ans) {
            for (int x : line) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
