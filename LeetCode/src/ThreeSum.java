import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yaodh on 2014/11/28.
 * <p/>
 * LeetCode: 3Sum
 * Link: https://oj.leetcode.com/problems/3sum/
 * Description:
 * -----------------------------
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 * -----------------------------
 * <p/>
 * Tag: Sort
 */
public class ThreeSum {
    /*public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num.length < 3) return ans;
        Arrays.sort(num);
        int i=0, j=num.length-1;
        while(i<j) {
            int target = -num[i]-num[j];
            List<Integer> list = generate(num[i],num[j],target);
            if(num[i] == 0 && num[j] ==0) {
                if(j-i>=2) ans.add(list);
                else break;
            }
            if((target==num[i] && num[i]==num[i+1])
                    ||(target==num[j] && num[j]==num[j-1])) {
                ans.add(list);
            }
            if(target<num[i]) j--;
            else if(target>num[j]) i++;
            else {
                int idx = Arrays.binarySearch(num, target);
                if(idx>=0) {
                    ans.add(list);
                }
                i++;
            }

        }
        return ans;
    }*/
    public List<Integer> generate(int x, int y, int z) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(x);
        list.add(y);
        list.add(z);
        return list;
    }
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num.length < 3) return ans;
        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            int k = i + 1;
            while (k < num.length && num[k] == num[i]) k++;
            int pre = num[i];
            for (int j = k; j < num.length; j++) {
                if (num[j] == pre) continue;
                pre = num[j];
                int idx = Arrays.binarySearch(num, -num[i] - num[j]);
                if (idx > j
                        || (idx == j && j + 1 < num.length && num[j] == num[j + 1])) {
                    ans.add(generate(num[i], num[j], -num[i]-num[j]));
                }
            }
            if (k - i > 2 && num[i] == 0) {
                ans.add(generate(0, 0, 0));
            } else if (k - i > 1) {
                int idx = Arrays.binarySearch(num, -num[i] * 2);
                if (idx >= k) {
                    ans.add(generate(num[i],num[i],num[idx]));
                }
            }
            i = k - 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new ThreeSum().threeSum(new int[]{-1, 0, 1, 0});
        for (List<Integer> line : ans) {
            for (int x : line) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
