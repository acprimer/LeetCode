import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 15/8/2.
 */
public class CombinationSumIII {
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        if(k <= 0 || n <= 0) {
            return ans;
        }
        dfs(n, 0, new ArrayList<Integer>(), k);
        return ans;
    }

    private void dfs(int target, int last, List<Integer> nums, int k) {
        if(target == 0 && k == 0) {
            ans.add(nums);
        }
        if(target < 0 || k < 0 || last >= 9) {
            return ;
        }
        for (int i = last + 1; i < 10; i++) {
            List<Integer> list = new ArrayList<Integer>();
            list.addAll(nums);
            list.add(i);
            dfs(target - i, i, list, k - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new CombinationSumIII().combinationSum3(3, 9);
        for(List<Integer> list : ans) {
            for(int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
