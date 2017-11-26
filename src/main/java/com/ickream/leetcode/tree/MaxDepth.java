package com.ickream.leetcode.tree;

/**
 * Created by xf on 2017/11/26.
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int rDepth=maxDepth(root.right);
        int lDepth=maxDepth(root.left);
        return rDepth>lDepth?rDepth+1:lDepth+1;
    }
}
