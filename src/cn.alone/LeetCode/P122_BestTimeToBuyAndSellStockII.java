package cn.alone.LeetCode;

/**
 * Created by RojerAlone on 2017-08-11.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 给一个数组，第 i 个数表示股票第 i 天的价格，算出利润
 */
public class P122_BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                res += prices[i + 1] - prices[i];
            }
        }
        return res;
    }

}
