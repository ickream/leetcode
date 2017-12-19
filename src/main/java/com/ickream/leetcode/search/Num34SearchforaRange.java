package com.ickream.leetcode.search;

/**
 * ***
 * Created by xf on 2017/12/15.
 */
public class Num34SearchforaRange {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
        int lo = 0, hi = nums.length-1, mid;
        while(lo <= hi){
            mid = (lo + hi)/2;
            if(nums[mid] > target){
                hi = mid - 1;
                continue;
            }
            if(nums[mid] < target){
                lo = mid + 1;
                continue;
            }
            lo = mid;
            hi = mid;
            while(lo>=0 && nums[lo] == target){
                lo--;
            }
            while (hi<=nums.length-1 && nums[hi] == target){
                hi++;
            }
            return new int[] {lo+1, hi-1};
        }
        return new int[]{-1, -1};

    }

    public int[] searchRange2(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1, -1};
        }
        int lo = binarySearch(nums, target);
        int hi = binarySearch(nums, target + 1) - 1;
        if(lo == nums.length || nums[lo] != target){
            return new int[]{-1, -1};
        }
        return new int[]{lo, hi};

    }

    /**
     * 这个函数不仅仅是二叉搜索
     * 一个数组有序且有重复然后
     * 二分查找寻找目标值的起点
     * @param nums
     * @param target
     * @return
     */
    private int binarySearch(int[] nums, int target){
        int lo = 0, hi = nums.length, mid;
        while(lo < hi){
            mid = (lo + hi)/2;
            if(nums[mid] < target){
                lo = mid + 1;
            }else {
                hi = mid;
            }
        }
        return lo;
    }
}
