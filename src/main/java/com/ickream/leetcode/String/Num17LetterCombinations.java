package com.ickream.leetcode.String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xf on 2017/12/4.
 * 电话号码上的字母的组合，，，
 * 回溯
 */
public class Num17LetterCombinations {
    private List<String> result = new ArrayList<>();
    private String[] strings = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0 || digits.indexOf('0')!=-1 || digits.indexOf('1')!=-1){
            return result;
        }
        helper(digits, 0, "");
        return result;
    }
    private void helper(String digits, int index, String str){
        if(index == digits.length()){
            result.add(str);
            return ;
        }
        int num =digits.charAt(index)-'2';
        for(int i=0; i<strings[num].length(); i++){
            helper(digits, index+1, str+strings[num].charAt(i));
        }
    }
}
