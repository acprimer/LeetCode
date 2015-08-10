import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yaodh on 15/8/10.
 */
public class ImplementStackUsingQueues {
    private Queue<Integer> q1 = new LinkedList<Integer>();
    private Queue<Integer> q2 = new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
        q2.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        q1.poll();
    }

    // Get the top element.
    public int top() {

        return q1.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
