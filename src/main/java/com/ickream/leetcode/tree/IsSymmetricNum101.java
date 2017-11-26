package com.ickream.leetcode.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xf on 2017/11/26.
 * 二叉树是否对称
 */
public class IsSymmetricNum101 {         //方法一 根据中序遍历和前序遍历或者后序遍历确定唯一一个二叉树的方法，这个方法不是最优解
    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> fnodes=new ArrayList<>();
        List<TreeNode> bnodes=new ArrayList<>();
        List<TreeNode> fnodes2=new ArrayList<>();
        List<TreeNode> bnodes2=new ArrayList<>();
        lnr(root, fnodes, "forward");
        nlr(root, fnodes2, "forward");
        lnr(root, bnodes, "backward");
        nlr(root, bnodes2, "backward");
        for( int i=0; i<fnodes.size();i++){
            if(fnodes.get(i).val!=bnodes.get(i).val||fnodes2.get(i).val!=bnodes2.get(i).val){
                return false;
            }
        }
        return true;

    }
    private void lnr(TreeNode root, List<TreeNode> nodes, String dir){
        if(root==null){
            return;
        }
        lnr(dir.equals("forward")? root.left:root.right, nodes, dir);
        nodes.add(root);
        lnr(dir.equals("forward")? root.right:root.left, nodes, dir);
    }
    private void nlr(TreeNode root, List<TreeNode> nodes, String dir){
        if(root==null){
            return;
        }
        nlr(dir.equals("forward")? root.left:root.right, nodes, dir);
        nlr(dir.equals("forward")? root.right:root.left, nodes, dir);
        nodes.add(root);
    }
    private void versal(TreeNode root){
        if(root==null){
            return ;
        }
        TreeNode tmp= root.left;
        root.left=root.right;
        root.right=tmp;
        versal(root.left);
        versal(root.right);
    }


    public boolean isSymmetric2(TreeNode root){           //方法二 递归 看着清爽多了
        return root==null||isSymmetric(root.left, root.right);

    }
    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null||left.val!=right.val){
            return false;
        }
        return isSymmetric(left.left, right.right)&&isSymmetric(left.right, right.left);

    }
}
