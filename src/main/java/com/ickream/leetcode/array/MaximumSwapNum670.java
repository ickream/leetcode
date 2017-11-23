package com.ickream.leetcode.array;

import java.util.Arrays;

/**
 * Created by xf on 2017/11/23.
 */
public class MaximumSwapNum670 {
    public int maximumSwap(int num) {
        char [] chars=(num+"").toCharArray();
        int max=num;
        for(int i=0;i<chars.length;i++){
            for(int j=i;j<chars.length;j++){
                change(chars, i, j);
                int tmp=Integer.parseInt(String.valueOf(chars));
                if(tmp>max){
                    max=tmp;
                }
                change(chars, i, j);
            }
        }
        return max;
    }
    private void change(char [] chars, int i, int j){
        char c=chars[i];
        chars[i]=chars[j];
        chars[j]=c;
    }
    public static void main(String [] args){
        MaximumSwapNum670 m=new MaximumSwapNum670();
        int a=m.maximumSwap(98368);
        System.out.println(a);
    }
}
