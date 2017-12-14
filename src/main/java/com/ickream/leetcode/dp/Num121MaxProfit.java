package com.ickream.leetcode.dp;

/**
 * Created by xf on 2017/12/11.
 */
public class Num121MaxProfit {
    public int maxProfit(int[] prices) {
        int dp = 0;
        int minPrice = prices[0];
        for(int i=1; i<prices.length; i++){
            int benefit = prices[i] - minPrice;
            dp = benefit > dp ? benefit : dp;
            minPrice = minPrice > prices[i] ? prices[i] : minPrice;
        }
        return dp;
    }
}
