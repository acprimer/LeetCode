import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 15/8/2.
 */
public class CombinationSumIII {
    /*List<List<Integer>> ans = new ArrayList<List<Integer>>();
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
    }*/

    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(k, n, new ArrayList<>(), 0, 0, 0);
        return ans;
    }

    private void dfs(int k, int n, List<Integer> list, int sum, int start, int use) {
        if (use > k) return;
        if (use == k && sum == n) {
            ans.add(new ArrayList<>(list));
        }
        for (int i = start + 1; i < 10; i++) {
            if (sum + start > n) break;
            list.add(i);
            dfs(k, n, list, sum + i, i, use + 1);
            list.remove(list.size() - 1);
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
