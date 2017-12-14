package com.ickream.leetcode.sort;

/**
 * Created by xf on 2017/12/14.
 */
public class Num75SortColors {
    public void sortColors(int[] nums) {
        if(nums.length == 0){
            return;
        }
        int redCount = 0, whiteCount = 0, blueCount = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                redCount++;
            }
            if(nums[i] == 1){
                whiteCount++;
            }
            if(nums[i] == 2){
                blueCount++;
            }
        }
        for(int i=0; i<nums.length; i++){
            if(i<redCount){
                nums[i] = 0;
            }
            if(i>=redCount && i<redCount+whiteCount){
                nums[i] = 1;
            }
            if(i>=redCount+whiteCount){
                nums[i] = 2;
            }
        }
    }
}
