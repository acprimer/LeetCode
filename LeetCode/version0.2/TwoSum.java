import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yaodh on 2014/11/2.
 * <p/>
 * LeetCode: Two Sum
 * Link: https://oj.leetcode.com/problems/two-sum/
 * Description:
 * -----------------------------
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * -----------------------------
 * <p/>
 * Tag: TwoPointers
 */
public class TwoSum {
    class Node {
        public Node(int x, int idx) {
            this.x = x;
            this.idx = idx;
        }

        int x;
        int idx;
    }

    // sort and two pointers
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int n = numbers.length;
        List<Node> list = new ArrayList<Node>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(numbers[i], i);
            list.add(node);
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.x != n2.x) return n1.x > n2.x ? 1 : -1;
                return n1.idx > n2.idx ? 1 : -1;
            }
        });
        for (int i = 0, j = n - 1; i < n; i++) {
            // because there is exactly one solution
            // so j can't be smaller than 0
            // so j>=0 is useless
            while (list.get(i).x + list.get(j).x > target) {
                j--;
            }
            if (list.get(i).x + list.get(j).x == target) {
                ans[0] = 1 + Math.min(list.get(i).idx, list.get(j).idx);
                ans[1] = 1 + Math.max(list.get(i).idx, list.get(j).idx);
                break;
            }
        }
        return ans;
    }
    // hash
    /*public int findIdx(int[] numbers, int x, int y){
        for(int i=0;i<numbers.length;i++){
            if(i!=y && x == numbers[i]){
                return i;
            }
        }
        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int x = numbers[0];	// min number
        int y = numbers[0];	// max number
        for(int num : numbers){
            if(num < x){
                x = num;
            }
            else if(num > y){
                y = num;
            }
        }
        for(int i=0;i<numbers.length;i++){
            numbers[i] -= x;
        }
        target -= 2*x;
        int[] hash = new int[2*(y - x + 1)];
        for(int i=0;i<hash.length;i++){
            hash[i] = 0;
        }
        for(int num : numbers){
            hash[num]++;
        }
        int tempx = 0, tempy = 0;
        for(int i=0;i<=(y-x)/2;i++){
            if(hash[i] > 0){
                if((target-i == i && hash[i] > 1) || (target-i != i && hash[target-i] > 0)){
                    tempx = i;
                    tempy = target - i;
                    break;
                }
            }
        }
        tempx = findIdx(numbers, tempx, -1) + 1;
        tempy = findIdx(numbers, tempy, tempx - 1) + 1;
        ans[0] = Math.min(tempx, tempy);
        ans[1] = Math.max(tempx, tempy);
        return ans;
    }*/
}
