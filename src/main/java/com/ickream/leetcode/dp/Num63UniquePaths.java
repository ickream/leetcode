package com.ickream.leetcode.dp;

import java.util.Arrays;

/**
 * Created by xf on 2017/12/12.
 * 62的基础上加了一个障碍物
 */
public class Num63UniquePaths {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length==0 || obstacleGrid[0].length==0 || obstacleGrid[0][0]==1){
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0){
                    dp[i][j] = 1;
                }
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }
                if(i==0&&j>0&&dp[i][j-1]==0 || j==0&&i>0&&dp[i-1][j]==0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(obstacleGrid[i][j] != 1){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return obstacleGrid[m-1][n-1]==1 ? 0 : dp[m-1][n-1];

    }

    /**
     *仔细看看没怎么看明白，边界条件问题
     * @param obstacleGrid
     * @return
     */

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if(obstacleGrid.length==0 || obstacleGrid[0].length==0 ){
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        dp[0][1] = 1;                                         //???
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(obstacleGrid[i-1][j-1] == 0){
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args){
        int[] arr = new int[3];
        System.out.println(arr[0]);
    }
}
