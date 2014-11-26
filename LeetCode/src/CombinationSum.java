import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/26.
 */
public class CombinationSum {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, 0, 0, target, new ArrayList<Integer>());
        return ans;
    }

    private void dfs(int[] candidates, int start, int sum, int target, List<Integer> list) {
        if (sum == target) {
            ans.add(list);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            List<Integer> newList = new ArrayList<Integer>(list);
            newList.add(candidates[i]);
            dfs(candidates, i + 1, sum + candidates[i], target, newList);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> line : ans) {
            for (int x : line) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
