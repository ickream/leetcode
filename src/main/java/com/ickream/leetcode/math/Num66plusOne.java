package com.ickream.leetcode.math;

/**
 * Created by xf on 2017/12/15.
 */
public class Num66plusOne {
    public int[] plusOne(int[] digits) {   //不对 ， 能计算的位数太少
        if(digits.length == 0){
            return new int[]{1};
        }
        String str = "";
        for(int i=0; i<digits.length; i++){
            str+=digits[i];
        }
        long tmp = Long.parseLong(str) + 1;
        str = tmp + "";
        int[] result = new int[str.length()];
        for(int i=0; i<result.length; i++){
            result[i] = str.charAt(i) - '0';
        }
        return result;
    }

    public int[] plusOne2(int[] digits) {
        if(digits.length == 0){
            return new int[]{1};
        }
        int len = digits.length, plus=1;
        for(int i=len-1; i>=0; i--){
            digits[i] += plus;
            if(digits[i] < 10){
                plus = 0;
                break;
            }
            plus = 1;
            digits[i] = 0;
        }
        if(plus == 0){
            return digits;
        }
        int[] result = new int[len+1];
        result[0] = 1;
        System.arraycopy(digits, 0, result, 1, len);
        return result;
    }
}
