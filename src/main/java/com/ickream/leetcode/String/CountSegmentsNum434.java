package com.ickream.leetcode.String;

/**
 * Created by xf on 2017/11/27.
 */
public class CountSegmentsNum434 {
    public static int countSegments(String s) {
        int n=0;
        String [] strArr=s.split("\\s+");
        if(strArr.length==0){
            return 0;
        }
        if(strArr[0].equals("")){
            n++;
        }
        if(strArr[strArr.length-1].equals("")){
            n++;
        }
        return 0>strArr.length-n?0:strArr.length-n;
    }
    public static void main(String [] args){
        System.out.println(countSegments("    foo    bar"));
    }
}
