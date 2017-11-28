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
    public List<List<Integer>> fourSum2(int[] nums, int target){
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();
        if(nums.length < 4){
            return result;
        }
        for(int i=0;i<nums.length-3;i++){
            //在网上看到的优化方法，，，不加也没问题
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                continue; //first candidate too large, search finished
            }
            if(nums[i]+nums[nums.length-1]+nums[nums.length-2]+nums[nums.length-3]<target){
                continue; //first candidate too small
            }

            if(i!=0&&nums[i]==nums[i-1]){       //去重复
                continue;
            }
            threeSum(nums, result, i, target);
        }

        return result;
    }
    private void threeSum(int[] nums, List<List<Integer>> result, int start, int target){
        for (int i = start+1; i < nums.length - 2; i++) {

            if(nums[start]+nums[i]+nums[i+1]+nums[i+2]>target){   //优化
                break; //second candidate too large
            }
            if(nums[start]+nums[i]+nums[nums.length-1]+nums[nums.length-2]<target){
                continue; //second candidate too small
            }

            if(i!=start+1&&nums[i-1]==nums[i]){          //去重验证
                continue;
            }
            int lo=i+1,hi=nums.length-1,sum=target-nums[start]-nums[i];
            while(lo<hi){
                if((lo>i+1&&nums[lo-1]==nums[lo])||nums[lo]+nums[hi]<sum){  //这里也有去重验证
                    lo++;
                    continue;
                }
                if(nums[lo]+nums[hi]>sum){                    //第三个数不用验证
                    hi--;
                    continue;
                }
                result.add(Arrays.asList(nums[start],nums[i],nums[lo],nums[hi]));
                lo++;
                hi--;
            }
        }
    }

}
