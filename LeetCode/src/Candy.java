/**
 * Created by yaodh on 2014/11/13.
 *
 * LeetCode: Candy
 * link: https://oj.leetcode.com/problems/candy/
 * description:
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * --Each child must have at least one candy.
 * --Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * Tag: Greedy
 */
public class Candy {
    public int candy(int[] ratings) {
        if(ratings.length <= 1) {
            return ratings.length;
        }
        int n = ratings.length;
        int[] height = new int[n+1];
        // give each child only one candy
        for(int i=0;i<n;i++) {
            height[i] = 1;
        }
        // guarantee that the right child get more candies than the left child
        for(int i=1;i<n;i++) {
            if(ratings[i] > ratings[i-1]) {
                height[i] = height[i-1] + 1;
            }
        }
        // guarantee that the left child get more candies than the right child
        for(int i=n-2;i>=0;i--) {
            if(ratings[i] > ratings[i+1]) {
                height[i] = Math.max(height[i], height[i+1]+1);
            }
        }
        int ans = 0;
        for(int i =0;i<n;i++) {
            ans += height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new Candy().candy(new int[]{5,1,1,1,10,2,1,1,1,3});
        System.out.println(ans);
    }
}
