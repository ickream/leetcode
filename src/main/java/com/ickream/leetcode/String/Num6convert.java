package com.ickream.leetcode.String;

import java.util.Arrays;

/**
 * Created by xf on 2017/12/4.
 *  ZigZag Conversion
 */
public class Num6convert {
    public static  String convert(String s, int numRows) {
        if(s.length() < 2 || numRows ==1){
            return s;
        }
        char[][] chars = new char[numRows][s.length()/2+1];
        for(char [] carr: chars){
            Arrays.fill(carr, '#');
        }
        int i = 0,j = 0, k = 0;
        String flag = "down";
        while(k < s.length()){
            if(flag.equals("down")){
                if(i == numRows){
                    flag = "up";
                    i--;
                    continue;
                }
                chars[i++][j] = s.charAt(k++);
            }else{
                chars[--i][++j] = s.charAt(k++);
                if(i == 0){
                    i++;
                    flag = "down";
                }
            }
        }
        StringBuilder str = new StringBuilder(s.length());
        for(i=0; i<chars.length; i++){
            for(j=0; j<chars[0].length; j++){
                if(chars[i][j] !='#'){
                    str.append(chars[i][j]);
                }
            }
        }
        return str.toString();
    }

    /**
     *
     * @param s
     * @param numRows
     * @return
     */
    public static  String convert2(String s, int numRows) {
        if (s.length() < 2) {
            return s;
        }
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int k=0; k<numRows; k++){                      //这里不能用foreach方式给数组项进行初始化
            sbs[k] = new StringBuilder();
        }

        int row, i = 0;
        while (i < s.length()){
            for(row=0; row<numRows && i<s.length(); row++){
                sbs[row].append(s.charAt(i));
                i++;
            }
            for(row=numRows-2; row>=1 && i<s.length(); row-- ){
                sbs[row].append(s.charAt(i));
                i++;
            }
        }
        StringBuilder result = new StringBuilder();
        for(i=0; i<numRows; i++){
            result.append(sbs[i]);
        }
        return result.toString();
    }



    public static void main(String[] args){

        convert("ABC", 2);
    }
}
