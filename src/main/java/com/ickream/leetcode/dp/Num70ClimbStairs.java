package com.ickream.leetcode.dp;

/**
 * 爬楼梯问题
 * Created by xf on 2017/12/19.
 */
public class Num70ClimbStairs {
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int dp1 = 1, dp2 = 2;
        for(int i=3; i<=n; i++){
            int cur = dp1 + dp2;
            dp1 = dp2;
            dp2 = cur;
        }
        return dp2;
    }
}
