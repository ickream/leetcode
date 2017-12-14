package com.ickream.leetcode.array;

import java.util.Arrays;

/**
 * Created by xf on 2017/12/10.
 * 字典排序的下一个排序，再仔细看看，，，
 */
public class Num31NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1){
            return;
        }
        int i = nums.length - 2;
        while(i>=0 && nums[i] >= nums[i+1]){
            i--;
        }
        if(i == -1){
            Arrays.sort(nums);
            return;
        }
        int j = i+1;
        for(int k=i+1; k<nums.length; k++){
            if(nums[k]<nums[j] && nums[k]>nums[i]){
                j = k;
            }
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        Arrays.sort(nums, i+1,nums.length);
    }
    public static void main(String[] args){
        int[] arr = new int[]{3,2,5,1,4};
        Arrays.sort(arr, 2,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
