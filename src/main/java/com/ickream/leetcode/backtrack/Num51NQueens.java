package com.ickream.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xf on 2017/12/13.
 * n皇后问题 回溯
 */
public class Num51NQueens {
    private List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        int [] arr = new int[n];
        check(0, n, arr);
        return result;
    }
    private void check(int  k,int max, int[] arr){
        if(k==max){
            List<String> item = new ArrayList<>();
            for(int i=0; i<max; i++){
                String str = "";
                for(int j=0; j<max; j++){
                    str += arr[i]==j ? 'Q' : '.';
                }
                item.add(str);
            }
            result.add(item);
            return;
        }
        for(int i=0;i<max;i++){
            arr[k]=i;
            if(judge(arr, k)){
                check(k+1, max, arr);
            }
        }
    }
    private boolean judge(int [] arr, int k){
        for(int i=0;i<k;i++){
            if(arr[i]==arr[k]|| Math.abs(arr[i]-arr[k])==Math.abs(i-k)){
                return false;
            }
        }
        return  true;
    }
}
