package com.ickream.leetcode.sort;

import java.util.Arrays;

/**
 * Created by xf on 2017/11/20.
 */
public class ABubbleSort {
    public static void bubbleSort(int [] array){
        for( int i=0;i<array.length-1;i++){
            boolean flag=false;
            for(int j=array.length-1;j>i;j--){
                if(array[j]<array[j-1]){
                    array[j-1]=array[j-1]+array[j];
                    array[j]=array[j-1]-array[j];
                    array[j-1]=array[j-1]-array[j];
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
    public static void main(String []args){
        int [] arr=new int[]{21,4,7,1,34,12,30};
        int [] arr1=new int[]{1,2,3,4,5,3};
        bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));

        if(-9999>Integer.MIN_VALUE){
            System.out.println("minminimin");
        }
    }
}

