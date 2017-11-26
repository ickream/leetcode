package com.ickream.leetcode.tree;

import com.sun.xml.internal.fastinfoset.algorithm.IntEncodingAlgorithm;
import sun.misc.LRUCache;
import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Created by xf on 2017/11/19.
 */
public class LevelOrderNum102 {             //一
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrder=new LinkedList<>();
        List<TreeNode> subLevel=new ArrayList<>();
        if(root==null){
            return levelOrder;
        }
        subLevel.add(root);
        while (true){
            levelOrder.add(getIntList(subLevel));
            List<TreeNode> subTrees=new ArrayList<>();
            Iterator<TreeNode> subIterator=subLevel.iterator();
            while(subIterator.hasNext()){
                TreeNode treeNode=subIterator.next();
                if(treeNode.left!=null){
                    subTrees.add(treeNode.left);
                }
                if (treeNode.right!=null){
                    subTrees.add(treeNode.right);
                }
            }
            if(subTrees.size()==0){
                break;
            }
            subLevel=subTrees;
        }
        return levelOrder;
    }

    private List<Integer> getIntList(List<TreeNode> list){
        List<Integer> integers =new ArrayList<>();
        Iterator<TreeNode> treeNodeIterator=list.iterator();
        while (treeNodeIterator.hasNext()){
            TreeNode treeNode=treeNodeIterator.next();
            integers.add(treeNode.val);
        }
        return integers;
    }

    public List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> nums=new ArrayList<>();
            int size=queue.size();               //这里利用队列的长度作为一层结束的标志位
            for(int i=0;i< size;i++){
                TreeNode  curNode= queue.poll();
                if(curNode.left!=null){
                    queue.offer(curNode.left);
                }
                if(curNode.right!=null){
                    queue.offer(curNode.right);
                }
                nums.add(curNode.val);
            }
            result.add(nums);
        }
        return result;
    }
}



/**
 * Definition for a binary tree node.
 **/
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

