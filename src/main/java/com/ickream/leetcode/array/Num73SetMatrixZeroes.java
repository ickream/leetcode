package com.ickream.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by xf on 2017/12/13.
 */
public class Num73SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {   //算法是错的
        if(matrix.length==0 || matrix[0].length==0){
            return;
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    helper(matrix, i, j);
                }
            }
        }
    }
    private static void helper(int[][] arr, int x, int y){
        for(int i=0; i<arr[0].length; i++){
            if(arr[x][i]==0 && i>y){
                helper(arr, x, i);
                continue;
            }
            arr[x][i] = 0;
        }
        for(int i=0; i<arr.length; i++){
            if(arr[i][y]==0 && i>x){
                helper(arr, i, y);
                continue;
            }
            arr[i][y] = 0;
        }
    }


    /**
     * 值为0所在行和列加入到一个set中存储
     * @param matrix
     */
    public static void setZeroes2(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0){
            return;
        }
        Set<Integer> row = new HashSet<>();
        Set<Integer> column = new HashSet<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    column.add(j);
                }
            }
        }
        for(int i : row){
            for(int j=0; j<matrix[0].length; j++){
                matrix[i][j] = 0;
            }
        }
        for(int j : column){
            for(int i=0; i<matrix.length; i++){
                matrix[i][j] = 0;
            }
        }
//        for(int i=0; i<matrix.length; i++){
//            for(int j=0; j<matrix[0].length; j++){
//                if(row.contains(i) || column.contains(j)){
//                   matrix[i][j] = 0;
//                }
//            }
//        }
    }

    /**
     * 用数组做缓存的速度比用集合类快很多 2ms 和 5ms
     * @param matrix
     */

    public static void setZeroes3(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length];
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(row[i]==1 || col[j]==1){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 空间复杂度为o(1) 用数据的最外层做缓存，再加两个标识为判断最外层是否是修改过
     * @param matrix
     */
    public static void setZeroes4(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        boolean isRowChange = false;
        boolean isColChange = false;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    // isRowChange = i==0;
                    // isColChange = j==0;
                    if(i==0){             //两个判断方式不等价！
                        isRowChange = true;
                    }
                    if(j == 0){
                        isColChange = true;
                    }
                }
            }
        }
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(isColChange){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        if(isRowChange){
            for(int j=0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }

    }

    public static void main(String[] args){
        int[][] arr = new int[][] {{0,0,0,5},{4,3,1,4},{1,2,1,3},{0,0,1,1}};
        setZeroes4(arr);
        //[[0,0,0,5],[4,3,1,4],[0,1,1,4],[1,2,1,3],[0,0,1,1]]
    }
}
