package com.ickream.leetcode.array;

/**
 * Created by xf on 2017/11/23.
 */
public class FindLengthOfLCISNum674 {
    public static int findLengthOfLCIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int[] dp=new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i]=1;
        }
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                dp[i]=dp[i-1]+1;
            }
        }
        int max=dp[0];
        for(int i=1;i<dp.length;i++){
            if(dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }
    public static void main(String [] args){
        int[] arr=new int[]{};
        System.out.println(findLengthOfLCIS(arr));
    }
}
