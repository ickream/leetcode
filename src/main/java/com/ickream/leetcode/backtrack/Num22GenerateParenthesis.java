package com.ickream.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by xf on 2017/12/7.
 * n对小括号的所有匹配方式
 */
public class Num22GenerateParenthesis {
    /**
     * 速度太慢需改进
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(n*2, 1, "(", result);
        return result;
    }
    private void helper(int n, int k, String str,List<String> result){
        if(k == n){
            if(isParenthesis(str)){
                result.add(str);
            }
            return;
        }
        helper(n, k+1, str+"(", result);
        helper(n, k+1, str+")", result);
    }
    private boolean isParenthesis(String str){
        Stack<Character> stack = new Stack<>();
        char[] chars = new char[str.length()];
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(!stack.isEmpty() && c == ')' && stack.peek()=='('){
                stack.pop();
            }else{
                stack.push(str.charAt(i));
            }
        }
        return stack.isEmpty();
    }
}
