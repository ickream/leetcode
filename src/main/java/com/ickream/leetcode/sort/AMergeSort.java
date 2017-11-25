package com.ickream.leetcode.sort;

import java.util.Arrays;

/**
 * Created by xf on 2017/11/23.
 */
public class AMergeSort {
    public static int [] mergeSort(int [] array, int low, int high){
        if(array.length==0){
            return new int[0];
        }
        if(low==high){
            return new int []{array[low]};
        }
        int mid=(low+high)/2;
        int [] arr1= mergeSort(array, low, mid);
        int [] arr2= mergeSort(array, mid+1,high);
        int n=arr1.length+arr2.length;
        int i=0,j=0,k=0;
        int [] mergeArr=new int[n];
        while (k<n){                    //比较方式不好会造成排序不稳定
            mergeArr[k++]=j==arr2.length||i<arr1.length&&arr1[i]<=arr2[j]?arr1[i++]:arr2[j++];
        }
        return mergeArr;
    }

    public static void main(String []args){
        int [] arr=new int[]{2,2};
        int [] array=mergeSort(arr, 0,  arr.length-1);

        System.out.println(Arrays.toString(array)+"---");
    }
}
