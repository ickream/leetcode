package com.ickream.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by xf on 2017/12/14.
 */
public class Num79WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board.length==0 || board[0].length==0){
            return false;
        }
        int row = board.length, col = board[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                boolean result = helper(board, new boolean[row][col], word, "", i, j);
                if(result){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[][] board, boolean[][] isVisited, String word, String str,int i, int j){
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || isVisited[i][j] || word.indexOf(str)!=0){
            System.out.println(str );
            return false;
        }
        str += board[i][j];
        if(word.length()==str.length()){
            return word.equals(str);
        }
        boolean[][] newIsVisited = copyArr(isVisited);
        newIsVisited[i][j] = true;

        return helper(board, newIsVisited, word, str, i,j+1)||
            helper(board, newIsVisited, word, str, i,j-1)||
            helper(board, newIsVisited, word, str, i+1,j)||
            helper(board, newIsVisited, word, str, i-1,j);
    }
    private boolean[][] copyArr(boolean arr[][]){
        boolean[][] copy = new boolean[arr.length][arr[0].length];
        for(int i=0; i<copy.length; i++){
            copy[i] = Arrays.copyOf(arr[i],arr[0].length);
        }
        return copy;
    }



    public boolean exist2(char[][] board, String word) {
        if(board.length==0 || board[0].length==0){
            return false;
        }
        int row = board.length, col = board[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(helper2(board, word, "", i, j)){    //这样写格式似乎不好==
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper2(char[][] board, String word, String str,int i, int j){
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1 || board[i][j]=='#' || word.indexOf(str)!=0){
            System.out.println(str );
            return false;
        }
        str += board[i][j];
        if(word.length()==str.length()){
            return word.equals(str);
        }
        char[][] newBoard = copyCharArr(board);                 //这里的数据复制太浪费时间
        newBoard[i][j] = '#';

        return helper2(newBoard, word, str, i,j+1)||
                helper2(newBoard, word, str, i,j-1)||
                helper2(newBoard, word, str, i+1,j)||
                helper2(newBoard, word, str, i-1,j);
    }

    private char[][] copyCharArr(char arr[][]){
        char[][] copy = new char[arr.length][arr[0].length];
        for(int i=0; i<copy.length; i++){
            copy[i] = Arrays.copyOf(arr[i],arr[0].length);
        }
        return copy;
    }

    /**
     * 比较好的方法，关键在于防止重复访问
     * @param board
     * @param word
     * @param k
     * @param i
     * @param j
     * @return
     */

    private boolean helper3(char[][] board, String word, int k,int i, int j){
        if(k == word.length()){
            return true;
        }
        if(i<0 || i>board.length-1 || j<0 || j>board[0].length-1){
            return false;
        }
        if(word.charAt(k) != board[i][j] ){
            return false;
        }
        char c = board[i][j];                  //防止重复访问的方法，比较好，现场状态还原
        board[i][j] = '#';

        boolean cur = helper3(board, word, k+1, i,j+1)||
                helper3(board, word, k+1, i,j-1)||
                helper3(board, word, k+1, i+1,j)||
                helper3(board, word, k+1, i-1,j);
        board[i][j] = c;
        return cur;
    }


    public static void main(String[] args){
        boolean[][] arr = new boolean[3][4];
        System.out.println(arr[2][2]);

        char[][] chars = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        Num79WordSearch n79 = new Num79WordSearch();
        n79.exist(chars, "ABCESEEEFS");
    }
}
