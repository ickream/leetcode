package com.ickream.leetcode.array;

import java.util.Arrays;

/**
 * Created by xf on 2017/11/25.
 * 双指针算法
 * 求乘积小于k的连续子数组的个数
 */
public class NumSubarrayProductLessThanK713 {
    public static  int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1){
            return 0;
        }
        int low=0;
        int result=0;
        long p=1L;
        for(int i=0;i<nums.length;i++){
            p*=nums[i];
            while(p>=k){
                p=p/nums[low++];
            }
            result+=i-low+1;
        }

        return result;
    }
    public static void main(String [] args){
        int [] arr =new int[] {1,2,3};
        int n= numSubarrayProductLessThanK(arr, 100);
        System.out.println(n);
    }
}
