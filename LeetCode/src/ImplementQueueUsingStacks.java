import java.util.Stack;

/**
 * Created by yaodh on 15/8/6.
 */
public class ImplementQueueUsingStacks {
    Stack<Integer> in = new Stack<Integer>();
    Stack<Integer> out = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        in.push(x);
    }

    // Removes the element from in front of queue.
    public int pop() {
        pour();
        return out.pop();
    }

    // Get the front element.
    public int peek() {
        pour();
        return out.peek();
    }

    // 把in的元素倾倒入out中
    private void pour() {
        if(out.empty()) {
            while(!in.empty()) {
                out.push(in.pop());
            }
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return out.empty() && in.empty();
    }
}
