package com.ickream.leetcode.String;

/**
 * ***
 * Created by xf on 2017/12/19.
 * 字符串表示的大数相乘
 */
public class Num43MultiplyStrings {
    /**
     * 暴力解决 按照普通乘法规则相乘 ac,,,时间很慢
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if(num1.length()==0 || num2.length()==0 || num1.equals("0") || num2.equals("0")){
            return "0";
        }
        StringBuilder result = new StringBuilder();
        int plus = 0;
        for(int i=num2.length()-1; i>=0; i--){
            StringBuilder item = new StringBuilder();
            for(int k=0; k<num2.length()-1-i; k++){
                item.append(0);
            }
            int a = num2.charAt(i)-'0';
            for(int j=num1.length()-1; j>=0; j--){
                int b = num1.charAt(j)-'0';
                int tmp = a*b + plus;
                item.insert(0, tmp%10);
                plus = tmp/10;
            }
            if(plus != 0){
                item.insert(0, plus);
                plus = 0;
            }
            result = combine(result, item);
        }
        while (result.length()>1 && result.charAt(0)=='0'){
            result.deleteCharAt(0);
        }
        return result.toString();
    }
    private StringBuilder combine(StringBuilder sb1, StringBuilder sb2){
        StringBuilder result = new StringBuilder();
        int plus = 0, i=0;

        for( ; i<Math.min(sb1.length(), sb2.length()); i++){
            int a = sb1.charAt(sb1.length()-1-i) - '0';
            int b = sb2.charAt(sb2.length()-1-i) - '0';
            int tmp = a + b + plus;
            result.insert(0, tmp%10);
            plus = tmp/10;
        }
        StringBuilder str = sb1.length()>sb2.length() ? sb1 : sb2;

        for(; i<str.length(); i++){
            int a = str.charAt(str.length()-1-i) - '0';
            int tmp = a + plus;
            result.insert(0, tmp%10);
            plus = tmp/10;
        }
        if(plus != 0){
            result.insert(0, plus);
        }
        return result;
    }


    /**
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply2(String num1, String num2) {
        if(num1.length()==0 || num2.length()==0){
            return "0";
        }
        int len1 = num1.length(), len2 = num2.length(), plus = 0;
        int[] arr = new int[len1+len2];
        for(int i=len1-1; i>=0; i--){
            for(int j=len2-1; j>=0; j--){
                int index = len1-1-i + len2-1-j;
                arr[index] +=(num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                if(arr[index] > 9){
                    arr[index+1] += arr[index]/10;       //注意这里进位是要加上原位，因为有可能此处不为零
                    arr[index] = arr[index]%10;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--){
            if(arr[i]==0 && result.length()==0){
                continue;
            }
            result.append(arr[i]);
        }
        return result.length()==0 ? "0" : result.toString();
    }

    public static void main(String [] args){
        Num43MultiplyStrings num43 = new Num43MultiplyStrings();
        num43.multiply2("123", "456");

        System.out.println();
    }
}
