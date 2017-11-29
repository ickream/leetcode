package com.ickream.leetcode.math;

/**
 * Created by xf on 2017/11/28.
 */
public class ReverseInt {
    public static int reverse(int x) {
        String xstr=(new Integer(x)).toString();
        long num=0;
        for(int i=xstr.length()-1;i>=0;i--){
            if(xstr.charAt(i)!='-'){
                int tmp=xstr.charAt(i)-'0';
                num=num*10+tmp;
            }
            if(num> Integer.MAX_VALUE){
                return 0;
            }
        }
        return (int)(x>0?num:-num);
    }
    public static void main(String [] args){
        reverse(1534236469);
        System.out.println(964632435L*10);
    }
}
