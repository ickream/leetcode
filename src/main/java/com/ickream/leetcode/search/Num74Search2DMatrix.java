package com.ickream.leetcode.search;

/**
 * Created by xf on 2017/12/14.
 */
public class Num74Search2DMatrix {
    /**
     *两个二分查找， 理论应该是lnN + lnM 的时间复杂度
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int lo = 0, hi = matrix.length - 1, mid;
        while (lo <= hi){
            mid = (lo + hi)/2;
            if(matrix[mid][0]<=target && matrix[mid][matrix[0].length-1]>=target){
                return binarySearch(matrix[mid], target);
            }
            if(matrix[mid][0] > target){
                hi = mid - 1;
            }
            if(matrix[mid][matrix[0].length-1] < target){
                lo = mid + 1;
            }
        }
        return false;
    }
    private boolean binarySearch(int[] arr, int target){
        int lo = 0, hi = arr.length - 1, mid;
        while(lo <= hi){
            mid = (lo + hi)/2;
            if(arr[mid] == target){
                return true;
            }
            if(arr[mid] > target){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return false;
    }

    /**
     * 速度怎么一样，，，理论上这个是o(m+n)的时间复杂度
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0){
            return false;
        }
        int i = matrix.length - 1, j = 0;
        while (i>=0 && j<matrix[0].length){
            if(matrix[i][j] == target){
                return true;
            }
            if(matrix[i][j] > target){
                i--;
            }else {
                j++;
            }
        }
        return false;
    }
}
