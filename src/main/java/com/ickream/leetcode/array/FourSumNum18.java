package com.ickream.leetcode.array;

import java.util.*;

/**
 * Created by xf on 2017/11/27.
 */
public class FourSumNum18 {
    private List<List<Integer>> result= new ArrayList<>();              //用回溯会超时
    private Map<String, Integer[]> map =new HashMap<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Integer[] items= new Integer[4];
        find(nums, items, 0, -1, target);
        return this.result;
    }
    private void find(int[] nums, Integer [] items,int k, int index,int target){
        if(k==items.length||index+items.length-k>nums.length){
            if(target==0&&!map.containsKey(Arrays.toString(items))){
                map.put(Arrays.toString(items), items);
                result.add(new ArrayList<>(Arrays.asList(items)));
            }
            return;
        }
        for(int i=index+1; i<nums.length; i++){
            items[k]=nums[i];
            find(nums, items, k+1, i, target-nums[i]);
        }
    }

    /**
     * 双指针
     */
}
