import java.util.ArrayList;
import java.util.List;

/**
 * Created by yaodh on 2014/11/28.
 * <p/>
 * LeetCode: Generate Parentheses
 * Link: https://oj.leetcode.com/problems/generate-parentheses/
 * Description:
 * -----------------------------
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * -----------------------------
 * <p/>
 * Tag: Backtracking
 */
public class GenerateParentheses {
    List<String>[] dp;

    public List<String> generateParenthesis(int n) {
        dp = new List[n + 1];
        dfs(n);
        return dp[n];
    }

    private void dfs(int n) {
        if (dp[n] != null) return;
        dp[n] = new ArrayList<String>();
        if (n == 0) dp[0].add("");
        for (int i = 0; i < n; i++) {
            dfs(i);
            dfs(n - 1 - i);
            for (int j = 0; j < dp[i].size(); j++) {
                for (int k = 0; k < dp[n - 1 - i].size(); k++) {
                    dp[n].add('(' + dp[i].get(j) + ')' + dp[n - 1 - i].get(k));
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> ans = new GenerateParentheses().generateParenthesis(5);
        for (String line : ans) {
            System.out.println(line);
        }
    }
}
