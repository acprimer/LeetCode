import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yaodh on 15/8/2.
 */
public class KthLargestElementInAnArray {
//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k + 1);
//        for(int x : nums) {
//            queue.offer(x);
//            if(queue.size() > k) {
//                queue.poll();
//            }
//        }
//        return queue.peek();
//    }

    /*
    public int findKthLargest(int[] nums, int k) {
        return find(nums, k, 0, nums.length - 1);
    }

    private int find(int[] A, int k, int start, int end) {
        int index = partition(A, start, end);
        int large = end - index + 1;
        if (large == k) {
            return A[index];
        } else if (large < k) {
            return find(A, k - large, start, index - 1);
        } else {
            return find(A, k, index + 1, end);
        }
    }

    private int partition(int[] A, int start, int end) {
        int pivot = A[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (A[j] < pivot) swap(A, ++i, j);
        }
        swap(A, ++i, end);
        return i;
    }

    private void swap(int[] A, int i, int j) {
        if (i == j) return;
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
    */

    public int findKthLargest(int[] nums, int k) {
        int[] heap = Arrays.copyOf(nums, k);
        int n = nums.length;
        buildHeap(heap, k);
        for (int i = k; i < n; i++) {
            if (nums[i] > heap[0]) {
                heap[0] = nums[i];
                adjust(heap, k, 0);
            }
        }
        return heap[0];
    }

    private void buildHeap(int[] heap, int size) {
        for (int i = (size-2)/2; i >=0 ; i--) {
            adjust(heap, size, i);
        }
    }

    private void adjust(int[] heap, int size, int root) {
        int left = root * 2 + 1;
        int right = root * 2 + 2;
        int smallest = root;
        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }
        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }
        if (smallest != root) {
            swap(heap, smallest, root);
            adjust(heap, size, smallest);
        }
    }

    private void swap(int[] A, int i, int j) {
        if (i == j) return;
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(new KthLargestElementInAnArray()
                .findKthLargest(new int[]{7,6,5,4,3,2,1}, 5));
        System.out.println(new KthLargestElementInAnArray()
                .findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(new KthLargestElementInAnArray()
                .findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
