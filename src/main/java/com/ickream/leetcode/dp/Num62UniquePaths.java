package com.ickream.leetcode.dp;

import java.util.Arrays;

/**
 * Created by xf on 2017/12/12.
 * 从格子的左上角走到右下角的路径数目
 * 动归
 */
public class Num62UniquePaths {
    public int uniquePaths(int m, int n) {
        if(m<1 || n<1){
            return 0;
        }
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(dp[i], 1);
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
