package com.ickream.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xf on 2017/12/18.
 * 寻找特定数其和为target， 元素可重复，关键在于恢复原来的状态
 */
public class Num39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
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
            if(target < candidates[i]){
                break;
            }
            item.add(candidates[i]);
            helper(result, item, candidates, i, target-candidates[i]);
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(4);
        System.out.println(arrayList.remove(0));

        Num39CombinationSum num39 = new Num39CombinationSum();
       // num39.combinationSum(new int[]{2,3,6,7}, 7);

    }
}
