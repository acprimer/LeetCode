import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null) return 0;
        int ans = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') continue;
            int x = 0;
            while (i < s.length() && Character.isDigit(s.charAt(i))) {
                x = x * 10 + (s.charAt(i) - '0');
                i++;
            }
            while (i < s.length() && s.charAt(i) == ' ') i++;
            char op2;
            // 处理乘除
            while (i < s.length() && isMulDiv(op2 = s.charAt(i))) {
                i++;
                int y = 0;
                while (i < s.length() && s.charAt(i) == ' ') i++;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    y = y * 10 + (s.charAt(i) - '0');
                    i++;
                }
                x = cal(x, y, op2);
            }
            ans = cal(ans, x, op);
            if (i < s.length()) op = s.charAt(i);
        }
        return ans;
    }

    private boolean isMulDiv(char op) {
        return op == '*' || op == '/';
    }

    private int cal(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default: return 0;
        }
    }

    public static void main(String[] args) {
//        System.out.println(new BasicCalculatorII().calculate("1 "));
//        System.out.println(new BasicCalculatorII().calculate("1 + 1"));
//        System.out.println(new BasicCalculatorII().calculate("2-1 + 2"));
//        System.out.println(new BasicCalculatorII().calculate("3+2*2"));
//        System.out.println(new BasicCalculatorII().calculate("2-5-6-1-2-5-4"));
//        System.out.println(new BasicCalculatorII().calculate("3/2"));
//        System.out.println(new BasicCalculatorII().calculate("1/3*3"));
//        System.out.println(new BasicCalculatorII().calculate("3 + 5 / 2"));
        System.out.println(new BasicCalculatorII().calculate("100000000/1/2/3/4/5/6/7/8/9/10"));
    }
}
