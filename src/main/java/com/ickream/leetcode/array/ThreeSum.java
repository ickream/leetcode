package com.ickream.leetcode.array;

import java.lang.annotation.Target;
import java.util.*;

/**
 * Created by xf on 2017/11/28.
 * kSum问题 向2Sum问题转化
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {    //先访问一点，然后转换为2Sum问题
        Arrays.sort(nums);                                 //去重有问题
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        if (nums.length<3) {
            return result;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            map.clear();
            if(i!=0&&nums[i-1]==nums[i]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int lastV = -nums[i] - nums[j];
                if (map.containsKey(lastV)) {
                    ArrayList<Integer> item = new ArrayList<>(Arrays.asList(nums[i], lastV, nums[j]));
                    result.add(item);
                    continue;
                }
                map.put(nums[j], j);

            }
        }
        //tmpMap.forEach((k,v)->result.add(v));
        return result;
    }

    //这个可以 之前去重验证时时间耗费太多
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length<3){
            return result;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if(i!=0&&nums[i-1]==nums[i]){          //去重验证
                continue;
            }
            int lo=i+1,hi=nums.length-1,sum=-nums[i];
            while(lo<hi){
                if((lo>i+1&&nums[lo-1]==nums[lo])||nums[lo]+nums[hi]<sum){  //这里也有去重验证
                    lo++;
                    continue;
                }
                if(nums[lo]+nums[hi]>sum){                    //第三个数不用验证
                    hi--;
                    continue;
                }
                result.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                lo++;
                hi--;
            }
        }
        return result;
    }
    public static void main(String [] args){
        int [] arr= new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>>result = threeSum2(arr);

    }
}
