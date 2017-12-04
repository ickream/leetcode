package com.ickream.leetcode.math;

/**
 * Created by xf on 2017/12/4.
 * 判断数字是否是回文数字
 */
public class Num9IsPalindrome {
    /**
     * 速度比较慢
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        StringBuilder s = new StringBuilder(x+"");
        long xx = Long.parseLong(s.reverse().toString());
        return x == (int)xx;
    }

    /**
     * 先将数字翻转
     */
    public static boolean isPalindrome2(int x) {
        if(x < 0){
            return false;
        }
        int tmp = x;
        long rev = 0;
        while(tmp != 0){
            rev = rev*10 + tmp%10;
            tmp = tmp/10;
        }
        return (int)rev == x;
    }

    public static void main(String[] args){
        System.out.println(isPalindrome2(1221));
    }
}
