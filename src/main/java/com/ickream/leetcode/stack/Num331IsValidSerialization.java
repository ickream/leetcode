package com.ickream.leetcode.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by xf on 2017/12/1.
 *  验证字符串是否是二叉树的前序遍历
 *  不太明白，，，
 */

public class Num331IsValidSerialization {
    public static boolean isValidSerialization(String preorder) {
        if(preorder.equals("")){
            return false;
        }
        String [] strings = preorder.split(",");
        Stack<String> stack= new Stack<>();
        for(String cur : strings){
            while(cur.equals("#") && !stack.isEmpty() && stack.peek().equals("#")){
                stack.pop();
                if(stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
            stack.push(cur);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
    public static void main(String [] args){
        isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");

    }
}
