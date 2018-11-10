import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yaodh on 15/7/28.
 */
public class DifferentWaystToAddParentheses {

    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() <= 0) return Collections.emptyList();
        String[] opArray = ("+"+input).split("[\\d]+");
        char[] ops = new char[opArray.length-1];
        for (int i = 0; i < opArray.length-1; i++) {
            ops[i] = opArray[i+1].charAt(0);
        }
        String[] numArray = input.split("[-+*]");
        int[] nums = new int[numArray.length];
        for (int i = 0; i < numArray.length; i++) {
            nums[i] = Integer.parseInt(numArray[i]);
        }
        return dfs(nums, ops, 0, ops.length-1);
    }

    private List<Integer> dfs(int[] num, char[] ops, int start, int end) {
        if (start > end) return Collections.singletonList(num[end+1]);

        List<Integer> ans = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            List<Integer> left = dfs(num, ops, start, i-1);
            List<Integer> right = dfs(num, ops, i+1, end);
            ans.addAll(calList(left, right, ops[i]));
        }
        return ans;
    }

    private List<Integer> calList(List<Integer> left, List<Integer> right, char op) {
        List<Integer> ans = new ArrayList<>(left.size() * right.size());
        for (int x : left)
            for (int y : right)
                ans.add(calSingle(x,y,op));
        return ans;
    }

    private int calSingle(int a, int b, char op) {
        switch (op) {
            case '+': return a+b;
            case '-': return a-b;
            case '*': return a*b;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        for (int x : new DifferentWaystToAddParentheses().diffWaysToCompute("")) {
            System.out.println(x);
        }
//        String[] arr = "3+4-5".split("[-+*]");
//        System.out.println(arr.length);
//        for (String s : arr) {
//            System.out.println(s);
//        }
//
//        System.out.println("split 符号");
//        String[] brr = "+3".split("[\\d]+");
//        System.out.println(brr.length);
//        for (String s : brr) {
//            System.out.println(s);
//        }
    }
}
