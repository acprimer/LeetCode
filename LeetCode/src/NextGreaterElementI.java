import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);
        for (int x : nums2) {
            while (!stack.isEmpty() && x > stack.peek()) {
                map.put(stack.pop(), x);
            }
            stack.push(x);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElementI().nextGreaterElement(
                new int[]{4, 1, 2},
                new int[]{1, 3, 4, 2}
        )));
        System.out.println(Arrays.toString(new NextGreaterElementI().nextGreaterElement(
                new int[]{2,4},
                new int[]{1,2,3,4}
        )));
        System.out.println(Arrays.toString(new NextGreaterElementI().nextGreaterElement(
                new int[]{1, 3, 5, 2, 4},
                new int[]{6, 5, 4, 3, 2, 1, 7}
        )));
    }
}
