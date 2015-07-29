import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 15/7/28.
 */
public class DifferentWaystToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<Integer>();
        dfs(ans, input);
        return ans;
    }

    private void dfs(List<Integer> ans, String input) {

    }
}
