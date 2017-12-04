package com.ickream.leetcode.math;

/**
 * Created by xf on 2017/12/4.
 * 将数字转为罗马数字
 */
public class Num12IntToRoman {
    public static String intToRoman(int num) {
        String result = "";
        String str = num+"";
        String [] tmp = new String[] {"M", "C", "X", "I"};
        String [] tmp2 = new String[] {"#", "D", "L", "V"};
        for(int i=0; i<str.length(); i++){
            int x = str.charAt(i) - '5';
            String y = "";
            if(x < 4){
                for(int j=0; j<(x>=-1 ? Math.abs(x) : x+5); j++){
                    y+=tmp[i+4-str.length()];
                }
                if(x > 0){
                    y = tmp2[i+4-str.length()] + y;
                }else if(x >= -1){
                    y = y +tmp2[i+4-str.length()];
                }
            }else{
                y = tmp[i+4-str.length()] + tmp[i+3-str.length()];
            }
            result+=y;
        }
        return result;
    }

    /**
     *枚举？暴力有效的方法==
     * @param num
     */
    public String intToRoman2(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D","DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX","LXX","LXXX","XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII","IX"};
        return M[num/1000]+C[(num%1000)/100] + X[(num%100)/10] + I[(num%10)];
    }

    public static void main(String[] arga){

        System.out.println(intToRoman(1468));
        System.out.println("ds".indexOf('1'));
    }
}
