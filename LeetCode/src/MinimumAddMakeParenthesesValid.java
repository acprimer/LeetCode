import java.util.Stack;

/**
 * Created by yaodh on 2018/10/14.
 */
public class MinimumAddMakeParenthesesValid {
    public int minAddToMakeValid(String input) {
        if (input == null) return 0;
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (!stack.isEmpty() && match(stack.peek(), ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }

    private boolean match(char a, char b) {
        return a == '(' && b == ')';
    }

    public static void main(String[] args) {
        System.out.println(new MinimumAddMakeParenthesesValid().minAddToMakeValid("())"));
        System.out.println(new MinimumAddMakeParenthesesValid().minAddToMakeValid("((("));
        System.out.println(new MinimumAddMakeParenthesesValid().minAddToMakeValid("()"));
        System.out.println(new MinimumAddMakeParenthesesValid().minAddToMakeValid("()))(("));
    }
}
