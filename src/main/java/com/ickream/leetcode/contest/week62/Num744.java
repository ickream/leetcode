package com.ickream.leetcode.contest.week62;

/**
 * Created by xf on 2017/12/14.
 */
public class Num744 {
    public char nextGreatestLetter(char[] letters, char target) {
        char result = (char)('z'+1);
        char minChar = 'z';
        for(int i=0; i<letters.length; i++){
            if(letters[i] > target && result > letters[i]){
                result = letters[i];
            }
            minChar = minChar>letters[i] ? letters[i] : minChar;
        }
        return result > 'z' ? minChar : result;
    }
}
