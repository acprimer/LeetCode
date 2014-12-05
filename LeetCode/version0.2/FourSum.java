import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yaodh on 2014/12/2.
 * <p/>
 * LeetCode: 4Sum
 * Link: https://oj.leetcode.com/problems/4sum/
 * Description:
 * -----------------------------
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target?
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 * -----------------------------
 * <p/>
 * Tag: Sort TwoPointers
 */
public class FourSum {
    public List<Integer> generate(int x, int y, int z, int p) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(x);
        list.add(y);
        list.add(z);
        list.add(p);
        return list;
    }

    // O(n^3)
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num.length < 3) return ans;
        Arrays.sort(num);
        int i = 0;
        while (i <= num.length - 4) {
            int j = num.length - 1;
            while (i < j) {
                // i...j
                int start = i + 1, end = j - 1;
                while (start < end) {
                    int[] idx = twoSum(num, start, end, target - num[i] - num[j]);
                    if (idx[0] == -1) break;
                    ans.add(generate(num[i], num[idx[0]], num[idx[1]], num[j]));
                    start = idx[0] + 1;
                    end = idx[1] - 1;
                    while (start < end && num[start] == num[start - 1]) start++;
                }
                // move j
                int q = num[j];
                while (j > i && num[j] == q) j--;
            }
            // move i
            int p = num[i];
            while (i <= num.length - 4 && num[i] == p) i++;
        }
        return ans;
    }

    public int[] twoSum(int[] num, int start, int end, int target) {
        int[] ans = new int[]{-1, -1};
        while (start < end) {
            if (num[start] + num[end] == target) {
                ans[0] = start;
                ans[1] = end;
                return ans;
            }
            if (num[start] + num[end] > target) {
                end--;
            } else start++;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new FourSum().fourSum(new int[]{0, 0, 0, 0}, 0);
        for (List<Integer> line : ans) {
            for (int x : line) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
