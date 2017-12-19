package com.ickream.leetcode.tree;

import com.ickream.leetcode.ListNode;
import sun.reflect.generics.tree.Tree;

/**
 * Created by xf on 2017/12/18.
 */
public class ABST   {
    public TreeNode getBST(ListNode head){
        if(head == null){
            return null;
        }
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        while (head != null){
            insertBST(root, head.val);
            head = head.next;
        }
        return root;
    }
//    private void insertBST(TreeNode root, int val){
//        while(true){
//            if(root.val > val){
//                if(root.left != null){
//                    root = root.left;
//                }else {
//                    root.left = new TreeNode(val);
//                    break;
//                }
//            }else if(root.val < val){
//                if(root.right != null){
//                    root = root.right;
//                }else {
//                    root.right = new TreeNode(val);
//                    break;
//                }
//            }
//        }
//    }
    //再看看
    private TreeNode insertBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if(root.val > val){
            root.left = insertBST(root.left, val);
        }
        if(root.val < val){
            root.right = insertBST(root.right, val);
        }
        return root;
    }

    private TreeNode delete(TreeNode root, int val){
        if(root == null){
            return null;
        }
        if(root.val > val){
            root.left = delete(root.left, val);
        }else if(root.val < val){
            root.right = delete(root.right, val);
        }else {
            if(root.right == null){
                return root.left;
            }
            if(root.left == null){
                return root.right;
            }
            TreeNode t = root;
            root = getMin(root.right);
            root.right = deleteMin(t.right);
            root.left = t.left;
        }
        return root;
    }

    private TreeNode deleteMin(TreeNode root){
        if(root.left == null){
            return root.right;
        }
        root.left = deleteMin(root.left);
        return root;
    }
    private TreeNode deleteMax(TreeNode root){
        if(root.right == null){
            return root.left;
        }
        root.right = deleteMax(root.right);

        return root;
    }

    private TreeNode getMin(TreeNode root){
        if(root.left == null){
            return  root;
        }
        return getMin(root.left);
    }

    private TreeNode get(TreeNode root, int val){
        if(root.val == val){
            return root;
        }
        if(root.val > val){
            return get(root.left, val);
        }
        if(root.val < val){
            return get(root.right, val);
        }
        return null;
    }
}
