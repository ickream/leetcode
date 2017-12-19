package com.ickream.leetcode.search;

/**
 * Created by xf on 2017/12/15.
 */
public class Num278FirstBadVersion {
    public int firstBadVersion(int n) {
        if(n <= 1){
            return n;
        }
        long lo = 1, hi = n, mid;
        while(lo < hi){
            mid = (lo + hi)/2;
            if(!isBadVersion((int)mid)){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return (int)lo ;
    }
    private boolean isBadVersion(int num){ //这个函数没啥用，本来的代码看不见

        return false;
    }
}
