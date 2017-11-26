package com.ickream.leetcode.array;


/**
 * Created by xf on 2017/11/25.
 */
public class MaxAreaOfIslandNum695 {
    public int maxAreaOfIsland(int[][] grid) {
        int vis [][]= new int[grid.length][grid[0].length];
        for(int []varr:vis){
            for(int v:varr){
                v=-1;
            }
        }
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int tmp=search(grid, vis, i, j);
                    count=count>tmp?count:tmp;
                }
            }
        }
        return count;

    }
    private int search(int [][] grid,int [][] vis, int i,int j){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]==0||vis[i][j]==1){
            return 0;
        }
        vis[i][j]=1;
        return 1+search(grid, vis,i-1, j)+ search(grid, vis, i+1, j)+search(grid, vis, i, j-1)+search(grid, vis, i,j+1);

    }

}
