import java.util.PriorityQueue;

/**
 * Created by yaodh on 15/8/2.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k + 1);
        for(int x : nums) {
            queue.offer(x);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        System.out.println(new KthLargestElementInAnArray().findKthLargest(new int[]{3,2,1,5,6,4}, 2));
    }
}
