package com.ickream.leetcode.search;

/**
 * Created by xf on 2017/12/10.
 * 找到target在nums数组中的位置，如果没有找到，找到应该插入的位置。
 * 二分查找
 */
public class Num35SearchInsert {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        int lo = 0, hi = nums.length - 1, mid;
        while (lo <= hi){
            mid = (lo+hi)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > target){
                hi = mid - 1;
            }else {
                lo = mid + 1;
            }
        }
        return lo>=nums.length || nums[lo] >= target ? lo : lo+1;
    }
}
