import java.util.List;

/**
 * Created by yaodh on 2018/11/9.
 */
public class DifferentWaysAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        int[] num = new int[input.length()];
        char[] op = new char[input.length()];
        int numCount = 0, opCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                op[opCount++] = input.charAt(i);
                continue;
            }
            int x = 0;
            while(i<input.length() && Character.isDigit(input.charAt(i))) {
                x = x * 10 + (input.charAt(i) - '0');
                i++;
            }
            num[numCount++] = x;
        }
        return null;
    }

    private void dfs(int[] num, char[] ops, int index, int pre, char lastOp) {
        int ans = num[index];
        for (int i = index + 1; i < num.length; i++) {

        }
    }

    private int cal(int a, int b, char op) {
        switch (op) {
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            default: return a+b;
        }
    }
}
