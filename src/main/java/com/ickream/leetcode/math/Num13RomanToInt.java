package com.ickream.leetcode.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xf on 2017/12/4.
 * 将罗马数字转为十进制
 */
public class Num13RomanToInt {
    public int romanToInt(String s) {
        if(s.equals("")){
            return 0;
        }
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int i;
        for(i=0; i<s.length()-1; i++){
            int x = map.get(s.charAt(i));
            int y = map.get(s.charAt(i+1));
            result += x>=y ? x : -x;
        }
        result += map.get(s.charAt(i));
        return result;
    }
}
