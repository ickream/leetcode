package com.ickream.leetcode.array;

import java.util.Arrays;

/**
 * Created by xf on 2017/11/29.
 */
public class RemoveElementNum27 {
    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        if(nums.length==0||nums[0]>val || nums[nums.length-1] < val){
            return nums.length;
        }
        int hi=-1,lo=-1;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==val){
                lo = i;
                break;
            }
        }
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i]==val){
                hi = i;
                break;
            }
        }
        if(hi < lo){
            return nums.length;
        }
        System.arraycopy(nums ,hi+1, nums, lo, nums.length-hi-1);
        return nums.length-hi+lo-1;
    }

    public int removeElement2(int[] nums, int val) {    //双指针
        int hi = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[hi++] = nums[i];
            }
        }
        return hi;
    }
}
