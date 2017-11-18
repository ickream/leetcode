package com.ickream.leetcode.others;

import javax.swing.text.EditorKit;

/**
 * Created by xf on 2017/11/18.
 */
public class CountAndSayNum38 {
    public static String countAndSay(int n) {
        String endStr="1";
        for(int i=1;i<n;i++){
            String str="";
            int count=1;
            char say=endStr.charAt(0);
            for(int j=1;j<endStr.length();j++){
                if(endStr.charAt(j)== endStr.charAt(j-1)){
                    count++;
                }else{
                    str=str+count+endStr.charAt(j-1);
                    count=1;
                }
            }
            str=str+count+endStr.charAt(endStr.length()-1);
            endStr=str;
        }
        return endStr;
    }
    public static void main(String [] args){
        String str=countAndSay(5);
        System.out.println(str);
    }
}
