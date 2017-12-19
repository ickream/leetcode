package com.ickream.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ***
 * Created by xf on 2017/12/18.
 * 寻找和为target的元素，关键在于去重
 */
public class Num40CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> item = new ArrayList<>();
        if(candidates.length == 0){
            return result;
        }
        helper(result, new ArrayList<>(), candidates, 0, target);
        return result;
    }

    private void helper(List<List<Integer>> result,List<Integer> item, int[] candidates, int k, int target){
        if(k== candidates.length || target<=0){
            if(target == 0){
                result.add(new ArrayList<>(item));
            }
            return;
        }
        for(int i=k; i<candidates.length; i++){
            if(target < candidates[i]){                   //优化速度
                break;
            }
            if(i>k && candidates[i]==candidates[i-1]){    //去重验证！！
                continue;
            }
            item.add(candidates[i]);
            helper(result, item, candidates, i+1, target-candidates[i]);
            item.remove(item.size()-1);
            // while (i<candidates.length-1 && candidates[i+1]==candidates[i]){
            //     i++;
            // }
        }
    }
}
