import java.util.Arrays;
import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        if (s == null) return 0;
        char[] arr = new char[s.length()];
        int len = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') continue;
            if (ch == '(') {
                stack.push(len);
            } else if (ch == ')') {
                int x = calSub(arr, stack.peek(), len-1);
                len = stack.pop();
                char[] brr = String.valueOf(x).toCharArray();
                System.arraycopy(brr, 0, arr, len, brr.length);
                len += brr.length;
            } else {
                arr[len++] = ch;
            }
        }
        return calSub(arr, 0, len - 1);
    }

    // 要处理 2--1这种，有负号的
    // 2--1 = 2-(-1) = 3
    private int calSub(char[] arr, int start, int end) {
        int ans = 0;
        char op = '+';
        for (int i = start; i <= end; i++) {
            int num = 0;
            boolean neg = false;
            // 第一个运算符就是负号了
            if (arr[i] == '-') {
                neg = true;
                i++;
            }
            while (i <= end && Character.isDigit(arr[i])) {
                num = num * 10 + (arr[i] - '0');
                i++;
            }
            if (neg) num = -num;
            ans = cal(ans, num, op);
            // 第一个运算符
            if (i <= end) {
                op = arr[i];
            }
        }
        return ans;
    }

    private int cal(int a, int b, char op) {
        if (op == '+') return a+b;
        return a-b;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate("1 "));
        System.out.println(new BasicCalculator().calculate("1 + 1"));
        System.out.println(new BasicCalculator().calculate("2-1 + 2"));
        System.out.println(new BasicCalculator().calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(new BasicCalculator().calculate("2-(5-6)-(1-2-(5-4))"));
    }
}
