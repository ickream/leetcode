package com.ickream.leetcode.array;

/**
 * Created by xf on 2017/12/10.
 * Search in Rotated Sorted Array
 * 二分查找的变种
 * lo 和 hi 之间总有一半是有序的
 */
public class Num32Search {
    public static int search(int[] nums, int target) {
        if(nums.length < 1){
            return -1;
        }
        int lo = 0, hi = nums.length - 1, mid;
        while (lo <= hi){
            mid = (hi + lo)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] < nums[hi]){
                if(nums[mid]<target && nums[hi] >= target){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }else{
                if(nums[mid]>target && nums[lo]<=target){
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        search(new int[]{1}, 1);
    }
}
