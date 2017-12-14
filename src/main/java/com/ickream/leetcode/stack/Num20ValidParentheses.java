package com.ickream.leetcode.stack;

import java.util.Stack;

/**
 * Created by xf on 2017/12/12.
 * 括号匹配
 */
public class Num20ValidParentheses {
    public boolean isValid(String s) {
        if(s.length() == 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        stack.push(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            char tmp = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(tmp);
                continue;
            }
            char c = stack.peek();
            if(c=='('&&tmp==')' || c=='['&&tmp==']' || c=='{'&&tmp=='}'){
                stack.pop();
            }else{
                stack.push(tmp);
            }
        }
        return stack.isEmpty();
    }
}
