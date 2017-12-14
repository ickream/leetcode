package com.ickream.leetcode.math;

/**
 * Created by xf on 2017/12/7.
 * 不使用除号 称号 取余符号 计算除法
 */
public class Num29Divide {
    /**
     * 超时
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        long dividendL = dividend;
        long divisorL = divisor;
        if(divisor == 0){
            throw new ArithmeticException();
        }
        if(dividend==0 ||Math.abs(dividendL)<Math.abs(divisorL)){
            return 0;
        }
        int flag = -1;
        if(dividendL>0&&divisorL>0 || dividendL<0&&divisorL<0){
            flag = 1;
        }
        long i = 1;
        long sum =Math.abs(divisorL);
        long absDividendL = Math.abs(dividendL);
        long absDivsorL = Math.abs(divisorL);
        while(sum <= absDividendL){
            sum += absDivsorL;
            i++;
        }
        return (int)(i > Integer.MAX_VALUE ? Integer.MAX_VALUE:(flag>0 ? i : -i));
    }


    /**
     * 内部的除法形式
     * @param dividend
     * @param divisor
     * @return
     */

    public int divide2(int dividend, int divisor) {
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        if(divisor == 1){
            return dividend;
        }
        if(divisor == -1){
            return dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend;
        }
        if(dividend==0 ||a<b){
            return 0;
        }
        int isNegative = dividend>0&&divisor>0 || dividend<0&&divisor<0 ? 1 : -1;
        int res = 0;
        while(a >= b){
            int i = 0;
            long tmp = b;
            while (a > (tmp<<1)){
                tmp = tmp<<1;
                i++;
            }
            res+= 1<<i;
            a = a - tmp;
        }
        return isNegative>0 ? res : -res;
    }

    public static void main(String[] args){
    }
}
