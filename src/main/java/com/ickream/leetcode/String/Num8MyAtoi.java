package com.ickream.leetcode.String;

/**
 * Created by xf on 2017/12/3.
 */
public class Num8MyAtoi {
    public int myAtoi(String str) {
        int a = 0;
        try {
            a = Integer.parseInt(str);
        }catch (NumberFormatException e){
        }finally {
            return a;
        }
    }
    public static void main(String[] args){
//        int a = Integer.parseInt("");
//        System.out.println(a);
    }

}

