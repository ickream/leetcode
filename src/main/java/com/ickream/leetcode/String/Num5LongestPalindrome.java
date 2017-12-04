package com.ickream.leetcode.String;

import com.ickream.leetcode.array.Num16ThreeSumClosest;

import java.util.Arrays;

/**
 * Created by xf on 2017/12/3.
 */
public class Num5LongestPalindrome {
    /**
     * dp解法
     * @param s
     */
    public String longestPalindrome(String s) {
        if(s.length() == 0){
            return "";
        }
        if(s.length() == 1){
            return s;
        }

        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++){
            for(int j=0; j<s.length(); j++){
                dp[i][j] = i>=j;
            }
        }

        int start = 0,end = 0;
        for(int k=1; k<s.length(); k++){
            for(int i=0; i+k<s.length(); i++){
                int j = i+k;
                dp[i][j] = s.charAt(i)==s.charAt(j) && dp[i+1][j-1];
                if(dp[i][j] && end - start<k){
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end+1);
    }

    /**
     * 选择一个点向两端扩散
     * 此思路的非递归版本比较快
     * @param s
     * @return
     */

    public String longestPalindrome3(String s){
        if(s.length() == 0){
            return "";
        }
        String lenStr = s.charAt(0)+"";
        for(int i=0; i<s.length(); i++){
            String single = helper(s, i, i);
            String doub = helper(s, i, i+1);
            lenStr = lenStr.length()>single.length() ? lenStr : single;
            lenStr = lenStr.length()>doub.length() ? lenStr : doub;
        }
        return lenStr;
    }
    private String helper(String s, int lo, int hi){
        if(lo<0 || hi==s.length() || s.charAt(lo)!=s.charAt(hi)){
            return s.substring(lo+1, hi);
        }
        return helper(s, lo-1, hi+1);
    }







    public static void main(String[] args){
        Num5LongestPalindrome n = new Num5LongestPalindrome();
        n.longestPalindrome("babad");

        Integer.parseInt("324");
    }

}
