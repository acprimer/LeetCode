import java.util.Arrays;

/**
 * Created by yaodh on 2018/11/8.
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int p = 0, q = numbers.length - 1;
        while (p < q) {
            int sum = numbers[p] + numbers[q];
            if (sum > target) q--;
            else if (sum < target) p++;
            else break;
        }
        return new int[]{p + 1, q + 1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSumII().twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
