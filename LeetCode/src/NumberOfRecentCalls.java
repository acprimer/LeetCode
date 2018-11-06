import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yaodh on 2018/11/5.
 */
public class NumberOfRecentCalls {
    private Queue<Integer> queue = new LinkedList<>();

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        queue.offer(t);
        return queue.size();
    }

    public static void main(String[] args) {
        NumberOfRecentCalls calls = new NumberOfRecentCalls();
        System.out.println(calls.ping(1));
        System.out.println(calls.ping(100));
        System.out.println(calls.ping(3000));
        System.out.println(calls.ping(3001));
        System.out.println(calls.ping(3002));
    }
}
