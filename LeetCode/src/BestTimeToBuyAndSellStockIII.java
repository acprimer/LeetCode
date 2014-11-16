/**
 * Created by yaodh on 2014/11/16.
 *
 * LeetCode: Best Time to Buy and Sell Stock III
 * Link: https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 * Description:
 * -----------------------------
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * You may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 * -----------------------------
 *
 * Tag: Dynamic Programming
 */
public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int ans = 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int lowPrice = prices[0];
        for(int i=1;i<prices.length;i++) {
            ans = Math.max(ans, prices[i] - lowPrice);
            left[i] = ans;
            lowPrice = Math.min(lowPrice, prices[i]);
        }
        ans = 0;
        int highPrice = prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--) {
            ans = Math.max(ans, highPrice - prices[i]);
            right[i] = ans;
            highPrice = Math.max(highPrice, prices[i]);
        }
        ans = 0;
        for(int i=0;i<prices.length;i++) {
            ans = Math.max(ans, left[i] + right[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int ans = new BestTimeToBuyAndSellStockIII().maxProfit(new int[]{1,2});
        System.out.println(ans);
    }
}
