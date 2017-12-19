package com.ickream.leetcode.tree;

import java.util.ArrayList;

/**
 * 求BST中是否存在两个相加等于k的值
 * 先中序遍历转换成数组，在求解
 * Created by xf on 2017/12/19.
 */
public class Num653TwoSumIVBST {
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        lnr(root, arrayList);
        Integer[] nums = arrayList.toArray(new Integer[arrayList.size()]);
        int lo = 0, hi = nums.length-1;
        while(lo < hi){
            if(nums[lo] + nums[hi] < k){
                lo++;
                continue;
            }
            if(nums[lo] + nums[hi] > k){
                hi--;
                continue;
            }
            return true;
        }
        return false;
    }
    private void lnr(TreeNode root, ArrayList<Integer> arrayList){
        if(root == null){
            return;
        }
        lnr(root.left, arrayList);
        arrayList.add(root.val);
        lnr(root.right, arrayList);
    }
}
