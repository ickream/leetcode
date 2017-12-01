package com.ickream.leetcode.array;

import java.awt.*;

/**
 * Created by xf on 2017/11/29.
 */
public class StrStrNum28 {
    public int strStr(String haystack, String needle) {
        if(haystack.equals("")){
            return 0;
        }
        for(int i = 0; i < haystack.length()-needle.length() + 1; i++){
            if(haystack.charAt(i) != needle.charAt(0)){
                continue;
            }
            int flag = 0;
            for(int j = 0; j<needle.length(); j++){
                if(haystack.charAt(i+j) != needle.charAt(j)){
                    break;
                }
                flag++;
            }
            if(flag == needle.length()){
                return i;
            }
        }
        return -1;
    }
    public static void main(String [] args){
        System.out.println("".length());
    }
}
