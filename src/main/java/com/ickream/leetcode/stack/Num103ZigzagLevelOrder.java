package com.ickream.leetcode.stack;

import com.ickream.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by xf on 2017/12/1.
 * 树的广度优先遍历加上一个方向转换
 */
public class Num103ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        String dir = "ltor";
        while(!queue.isEmpty()){
            LinkedList<Integer> item = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode treeNode = queue.poll();
                if(dir.equals("ltor")){
                    item.add(treeNode.val);
                }else {
                    item.addFirst(treeNode.val);
                }
                if(treeNode.left != null){
                    queue.offer(treeNode.left);
                }
                if(treeNode.right !=null){
                    queue.offer(treeNode.right);
                }
            }
            dir = dir.equals("ltor") ? "rtol" :"ltor";
            result.add(item);
        }
        return result;
    }
}
