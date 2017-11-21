package com.ickream.leetcode.sort;

import java.util.Arrays;

/**
 * 插入排序 稳定 数组有序非逆序时，时间复杂度为O(n),平均为O(n^2)
 * Created by xf on 2017/11/20.
 */
public class AInsertSort {
    public static void insertSort(int [] array){
        for(int i=1;i<array.length;i++){
            for(int j=i;j>0&&array[j]<array[j-1];j--){  //这里的判断很重要，因为前面有序，
                int tmp=array[j];                   //故array[j]>array[j-1]时可以不用比较
                array[j]=array[j-1];                 //
                array[j-1]=tmp;
            }
        }
    }
    public static void main(String []args){
        int [] arr=new int[]{3,4,1,3,12,5,8};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
