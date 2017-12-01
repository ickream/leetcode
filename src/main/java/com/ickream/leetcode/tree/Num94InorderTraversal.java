package com.ickream.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xf on 2017/12/1.
 */
public class Num94InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        lnr(root, result);
        return result;
    }
    private void lnr(TreeNode root, List<Integer> result){
        if(root == null){
            return ;
        }
        lnr(root.left, result);
        result.add(root.val);
        lnr(root.right, result);
    }
}
