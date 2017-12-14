package com.ickream.leetcode.String;

/**
 * Created by xf on 2017/12/6.
 * 找到字符串数组的最长匹配前缀
 */
public class Num14LongestCommonPrefix {

    /**
     * 简单暴力破解，费时间
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        String str = "";
        if(strs.length == 0){
            return str;
        }
        int len = strs[0].length();
        for(int i=0; i<len; i++){
            str += strs[0].charAt(i);
            for(int j=0; j<strs.length; j++){
                if(len > strs[j].length()){
                    len = strs[j].length();
                }
                if(strs[j].indexOf(str) !=0){
                   return str.substring(0,i);
                }
            }
        }
        return str;
    }

    /**
     * o(n)算法
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(String str : strs){
            while(str.indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }
        return prefix;
    }
    public static void main(String[] args){
        System.out.println("".substring(0,0).length()+"-");
    }
}
