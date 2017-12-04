package com.ickream.leetcode.String;

/**
 * Created by xf on 2017/12/3.
 */
public class AKMP {

     private int[] calNext(String str){
         int[] next = new int[str.length()];
         next[0] = -1;
         for(int i=1; i<next.length; i++){
             int k = next[i-1];
             if(k>-1 && str.charAt(k)==str.charAt(i-1)){
                 next[i] = k+1;
             }else {
                 next[i] = 0;
             }
         }
         return next;
     }

     public int kmp(String str, String pstr){
         if(str == null || str.length() == 0){
             return 0;
         }
         int[] next = calNext(pstr);
         int i = 0,k = 0;
         while(i <= str.length()-pstr.length()){
             if(k == pstr.length()){
                 return i;
             }
             if(str.charAt(i+k) == pstr.charAt(k)){
                 k++;
             }else{
                 i = i+ k - next[k];
                 k =next[k]>0 ? next[k] : 0;
             }
         }
         return  -1;
     }
     public static void main(String [] args){
         AKMP akmp = new AKMP();
         System.out.println(akmp.kmp("ABB", "BB"));
     }
}
