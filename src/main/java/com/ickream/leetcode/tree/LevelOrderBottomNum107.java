package com.ickream.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xf on 2017/11/26.
 */
public class LevelOrderBottomNum107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result=new LinkedList<>();
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
            result.addFirst(nums);

        }
        return result;
    }
}
