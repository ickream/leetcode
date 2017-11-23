package com.ickream.leetcode.sort;

import java.util.Arrays;

/**
 * Created by xf on 2017/11/22.
 */
public class AQuickSort {

    private static void sort(int [] arr,int low,int high){
        if(low>=high){
            return;
        }
        int lo=low++;
        int hi=high;
        while(low<=high){
            if(arr[low]<=arr[lo]){
                low++;
                continue;
            }
            if(arr[high]>=arr[lo]){
                high--;
                continue;
            }
            change(arr,low,high);
        }
        change(arr, lo, high);
        sort(arr, lo, high-1);
        sort(arr, high+1,hi);
    }
    private static void change(int [] arr, int i, int j){
        int tmp=arr[i];
        arr[i]=arr[j];
        arr[j]=tmp;
    }
    public static void main(String [] args){
        //TODO nothing
        int[] arr=new int []{3,2,1};
        sort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
