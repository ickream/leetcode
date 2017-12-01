package com.ickream.leetcode.array;

import java.util.Arrays;

/**
 * Created by xf on 2017/11/30.
 */
public class Num80RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int n = 1, lo = 0;
        int dup = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != dup){
                nums[n++] = nums[i];
                dup = nums[i];
                lo = i;
                continue;
            }
            if(i == lo +1){
                nums[n++] = nums[i];
            }
        }
        return n;
    }

    public static void main(String [] args){
        int [] nums = new int[]{1,1,1,1};
         int len = removeDuplicates(nums);
        System.out.println(Arrays.toString(nums)+"---"+len);
    }
}
