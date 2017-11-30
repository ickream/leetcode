package com.ickream.leetcode.String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xf on 2017/11/30.
 */
public class Num3LengthOfLongestSubstring {                          //超时
    public static int lengthOfLongestSubstring(String s) {
        int result = 1;
        if(s.length() == 0){
            return 0;
        }
        StringBuilder subString  =new StringBuilder();
        subString.append(s.charAt(0));
        int i = 1;
        int len = s.length();
        while(i < len){
            if(s.charAt(i) != s.charAt(i-1) && subString.indexOf(s.charAt(i)+"") == -1){
                subString.append(s.charAt(i++))  ;
                result = result >subString.length() ? result :subString.length();
                continue;
            }
            if(subString.indexOf(s.charAt(i)+"") != -1){
                i = i+1 - subString.length() + subString.indexOf(s.charAt(i)+"");
                subString = new StringBuilder();
                subString.append(s.charAt(i++));
            }
        }
        return result;
    }

    public static int lengthOfLongestSubstring2(String s) {     //双指针
        int result = 0;
        if(s.length() == 0){
            return 0;
        }
        int [] arr = new int[256];
        Arrays.fill(arr, -1);
        int lo = 0, hi = 0;

        while(hi < s.length()){
            if(arr[s.charAt(hi)] >= lo){
                lo = arr[s.charAt(hi)] + 1;
                arr[s.charAt(hi)] = hi++;
                continue;
            }
            arr[s.charAt(hi)] = hi;
            result = result > hi - lo +1? result : hi - lo + 1;
            hi++;
        }
        return result;
    }

    public static void main(String [] args){
        int a = lengthOfLongestSubstring("abcabcbb");
    }
}
