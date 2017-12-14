package com.ickream.leetcode.stack;

import java.util.*;

/**
 * Created by xf on 2017/12/5.
 */
public class Num155MinStack {

    private LinkedList<Integer> stack;

    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public Num155MinStack() {
        stack = new LinkedList<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else {
            minStack.push(x>=minStack.peek() ? minStack.peek() : x);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
//        Iterator<Integer> iterator = stack.iterator();
//        int min = Integer.MAX_VALUE;
//        while (iterator.hasNext()){
//            int tmp = iterator.next();
//            min = min>tmp ? tmp : min;
//        }
//        return min;
        return minStack.peek();
    }
}
