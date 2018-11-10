import java.util.*;

/**
 * Created by yaodh on 2014/11/21.
 *
 * LeetCode: Min Stack
 * Link: https://oj.leetcode.com/problems/min-stack/
 * Description:
 * -----------------------------
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * ---push(x) -- Push element x onto stack.
 * ---pop() -- Removes the element on top of the stack.
 * ---top() -- Get the top element.
 * ---getMin() -- Retrieve the minimum element in the stack.
 * -----------------------------
 *
 * Tag: Stack
 */
public class MinStack {
    // 使用Stack实现
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        if(minStack.empty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int top = stack.pop();
        if(top == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
