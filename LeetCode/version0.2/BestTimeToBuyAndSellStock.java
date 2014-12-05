/**
 * Created by yaodh on 2014/11/16.
 *
 * LeetCode: Best Time to Buy and Sell Stock
 * Link: https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * Description:
 * -----------------------------
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * -----------------------------
 *
 * Tag: Array
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) {
            return 0;
        }
        int ans = 0;
        int lowPrice = prices[0];
        for(int i=1;i<prices.length;i++) {
            ans = Math.max(ans, prices[i] - lowPrice);
            lowPrice = Math.min(lowPrice, prices[i]);
        }
        return ans;
    }
}
