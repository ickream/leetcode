package com.ickream.leetcode.twopoints;

/**
 * Created by xf on 2017/12/19.
 */
public class Num167TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        if(numbers.length < 2){
            return new int[2];
        }
        int lo = 0, hi = numbers.length-1;
        while (lo < hi){
            if(numbers[lo]+numbers[hi] < target){
                lo++;
                continue;
            }
            if(numbers[lo]+numbers[hi] > target){
                hi--;
                continue;
            }
            return new int[]{lo+1, hi+1};
        }
        return new int[2];
    }
}
