package com.ickream.leetcode.sort;

import java.util.Arrays;

/**
 * 选择排序不稳定 ,排序时间和数组是否有序无关 均为O(n);
 * Created by xf on 2017/11/20.
 */
public class ASelectionSort {
    public static void selectionSort(int [] array){
        for(int i=0;i<array.length;i++){
            int index=i;
            for(int j=i;j<array.length;j++){
                if(array[index]>array[j]){
                    index=j;
                }
            }
            int tmp=array[index];
            array[index]=array[i];
            array[i]=tmp;
        }
    }
    public static void main(String []args){
        int[] arr=new int[] {4,2,4,1,12,5,9,19};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
