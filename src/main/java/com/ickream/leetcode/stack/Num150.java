package com.ickream.leetcode.stack;

import java.util.Stack;

/**
 * Created by xf on 2017/11/17.
 */
public class Num150 {
    public int evalRPN(String[] tokens) {
        Stack<String> num=new  Stack<>();
        for(int i=0;i<tokens.length;i++){
            if(!isOperator(tokens[i])){
                num.push(tokens[i]);
            }else{
//                int a=getInt(num.pop());
//                int b=getInt(num.pop());
                int a= Integer.parseInt(num.pop());
                int b = Integer.parseInt(num.pop());
                if(tokens[i].equals("+")){
                    num.push((a+b)+"");
                }else if(tokens[i].equals("-")){
                    num.push((b-a)+"");
                }else if(tokens[i].equals("*")){
                    num.push((b*a)+"");
                }else if(tokens[i].equals("/")){
                    num.push((b/a)+"");
                }
            }
        }
        return Integer.parseInt(num.pop());//num.size(); //
    }
    public int getInt(String str){
        int n=0;
        if(str.charAt(0)=='-'){
            for(int i=1;i<str.length();i++){
                n=n*10+str.charAt(i)-'0';
            }
            return -1*n;
        }else{
            for(int i=0;i<str.length();i++){
                n=n*10+str.charAt(i)-'0';
            }
            return n;
        }
    }
    public boolean isOperator(String str){
        return str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/");
    }
}
