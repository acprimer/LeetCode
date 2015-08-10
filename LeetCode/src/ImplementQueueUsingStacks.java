import java.util.Stack;

/**
 * Created by yaodh on 15/8/6.
 */
public class ImplementQueueUsingStacks {
    Stack<Integer> left = new Stack<Integer>();
    Stack<Integer> right = new Stack<Integer>();
    // Push element x to the back of queue.
    public void push(int x) {
        right.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(left.empty()) {
            while(!right.empty()) {
                left.push(right.peek());
                right.pop();
            }
        }
        left.pop();
    }

    // Get the front element.
    public int peek() {
        if(left.isEmpty()) {
            while(!right.isEmpty()) {
                left.push(right.peek());
                right.pop();
            }
        }
        return left.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return left.empty() && right.empty();
    }
}
