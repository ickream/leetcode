package com.ickream.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xf on 2017/11/28.
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {    //双指针，时间复杂度o(n) 但是代码量太多了，用哈希表
        int low=0;
        int high=nums.length-1;
        int [] arr= Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        while(low<high){
            if(nums[low]+nums[high]>target){
                high--;
                continue;
            }
            if(nums[low]+nums[high]<target){
                low++;
                continue;
            }
            break;
        }
        int [] result = new int[2];
        if(low<high){
            result[0]=getIndex(arr, nums[low], "forward");
            result[1]=getIndex(arr, nums[high], "backward");
        }
        return result;
    }
    private int getIndex(int [] arr, int v, String dir){
        int index=-1;
        if(dir.equals("forward")){
            for(int i=0;i<arr.length;i++){
                if(arr[i]==v){
                    index=i;
                    break;
                }
            }
        }else {
            for(int i=arr.length-1;i>=0;i--){
                if(arr[i]==v){
                    index=i;
                    break;
                }
            }
        }
        return index;
    }



    public int[] twoSum2(int[] nums, int target) {   //哈希表
        if(nums==null||nums.length<2){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
