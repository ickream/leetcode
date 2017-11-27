package com.ickream.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xf on 2017/11/27.
 */
public class CombinationSum3Num216 {
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        Integer [] arr = new Integer[k];
        combine(0, arr, n);
        return this.result;
    }
    private void combine(int num, Integer[] arr,int n){
        if(num==arr.length){
            if(n==0){
                result.add(new ArrayList<Integer>(Arrays.asList(arr)));
            }
            return;
        }
        for(int i=num==0?1:arr[num-1]+1; i<10; i++){    //数组未避免重复应该是一个递增数组，初始i 应比前一个数组的值大
            arr[num]=i;
            combine(num+1, arr, n-i);     //n-i 这里省去以后求和
        }
    }

    /**
     *求和和筛选直接在递归里进行
     *辅助函数就不需要了
     */
    private int sum(Integer [] item){
        int sum=0;
        for(int v : item){
            sum+=v;
        }
        return sum;
    }
    private boolean judge(Integer [] arr,int num){
        for(int i=0; i<num; i++){
            if(arr[i].equals(arr[num])||arr[i]>arr[num]){
                return false;
            }
        }
        return true;
    }

    public static void main(String [] args){
        CombinationSum3Num216 com=new CombinationSum3Num216();
        List<List<Integer>> result=com.combinationSum3(3, 7);
        System.out.println(result.size());
    }

}
