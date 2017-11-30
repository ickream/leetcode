package com.ickream.leetcode.array;

/**
 * Created by xf on 2017/11/29.
 */
public class MaxAreaNum11 {

    /**
     * 设初始点为height[lo] 和 height[hi], 面积为min(height[lo], height[hi])*(hi-lo);
     * 在两个点向中间靠拢时，(hi-lo)会变小,只有min(height[lo], height[hi])变大才有可能
     * 更新maxArea值， 故在只分析中间节点height[i] 比 初始点大的情况，留下height[lo] height[hi]中
     * 比较大的那个才有可能使得新的min(height[lo], height[hi])变大
     */
    public int maxArea2(int[] height) {
        int lo = 0, hi = height.length - 1;
        int maxArea = Math.min(height[lo], height[hi])*(hi - lo);

        int area;
        while(lo < hi){
            if(height[lo] >= height[hi]){
                hi--;
            }else {
                lo++;
            }
            area = Math.min(height[lo], height[hi])*(hi - lo);
            maxArea = maxArea > area ? maxArea :area;
        }
        return maxArea;
    }
}
