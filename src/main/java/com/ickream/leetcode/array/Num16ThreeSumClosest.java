package com.ickream.leetcode.array;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by xf on 2017/11/30.
 */
public class Num16ThreeSumClosest {                           //双指针法
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = 0;
        int closestV = Integer.MAX_VALUE;
        for(int i=0; i < nums.length-2; i++){
            if(i != 0 && nums[i-1] == nums[i+1]){
                continue;
            }
            int lo = i+1, hi = nums.length -1, sum = target - nums[i];
            while(lo < hi){
               int tmp = Math.abs(sum - nums[lo] - nums[hi]);
               if(closestV > tmp ){
                   closestV = tmp;
                   result = nums[i] + nums[lo] + nums[hi];
               }
               if(lo != i+1&&nums[lo-1]==nums[lo] || nums[lo] + nums[hi] <= sum){
                   lo++;
                   continue;
               }
               if(nums[lo] + nums[hi] > sum){
                   hi--;
               }
            }
        }
        return result;
    }

    public int threeSumClosest2(int[] nums, int target) {    //最快的一种方法
        int result = Integer.MAX_VALUE, n = nums.length;
        if (n > 2){
            // #0-数组排序
            Arrays.sort(nums);
            // #1-计算所有组合中的全局最小值与全局最大值
            int less = nums[0] + nums[1] + nums[2];
            int more = nums[n-3] + nums[n-2] + nums[n-1];
            // #1.1-如果全局最小值比target大
            if (less >= target)
                return less;
            // #1.2-如果全局最大值比target小
            if (more <= target)
                return more;
            // #2-计算以nums[i]开头的组合
            for (int i = 0; i < n - 2; i++){
                // #2.1-计算局部组合之和的最小值与最大值
                int min = nums[i] + nums[i+1] + nums[i+2];
                int max = nums[i] + nums[n-2] + nums[n-1];
                // #2.2-如果最小值比target大，则更新全局最大值
                if (min > target){
                    more = Math.min(more, min);
                    continue;
                }
                // #2.3-如果最大值比target小，则更新全局最小值
                if (max < target){
                    less = Math.max(less, max);
                    continue;
                }
                // #2.4-如果min<=target<=max
                int j = i + 1, k = n - 1;
                while (j < k){
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum > target){
                        more = Math.min(more, sum);
                        while (j < --k && nums[k] == nums[k+1]);
                    } else if (sum < target){
                        less = Math.max(less, sum);
                        while (++j < k && nums[j] == nums[j-1]);
                    } else {
                        return target;
                    }
                }
            }
            if (less == target || more == target)
                return target;
            result = more - target > target - less ? less : more;
        }
        return result;
    }

    public static void main(String [] args){
        Num16ThreeSumClosest n = new Num16ThreeSumClosest();

        int ss = n.threeSumClosest(new int[]{1,1,-1,-1,3}, -1);
    }
}
