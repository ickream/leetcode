package com.ickream.leetcode.dp;

/**
 * ***
 * Created by xf on 2017/12/19.
 */
public class Num746MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length == 2){
            return Math.min(cost[0], cost[1]);
        }
        int dp1 = cost[0], dp2 =cost[1];
        for(int i=2; i<cost.length; i++){
            int cur = Math.min(dp1 + cost[i], dp2 + cost[i]);      //dp[i]记录的是以后若经过i点到i+1点时需要的最小代价
            dp1 = dp2;
            dp2 = cur;
        }
        return Math.min(dp1, dp2);
    }

    public static void main(String[] args){
        minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
    }
}
