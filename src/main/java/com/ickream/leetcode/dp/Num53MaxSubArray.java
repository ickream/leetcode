package com.ickream.leetcode.dp;

/**
 * Created by xf on 2017/12/11.
 * 最大的和的子数组
 */
public class Num53MaxSubArray {
    public int maxSubArray(int[] nums) {
        if(nums.length ==0){
            return Integer.MIN_VALUE;
        }
        int dp = nums[0];
        int maxSum = dp;
        for(int i=1; i<nums.length; i++){
            dp = Math.max(dp+nums[i],nums[i]);
            maxSum = maxSum<dp ? dp : maxSum;
        }
        return maxSum;
    }
}
