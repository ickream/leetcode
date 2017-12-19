package com.ickream.leetcode.linklist;

import com.ickream.leetcode.TreeNode;

/**
 * Created by xf on 2017/12/19.
 */
public class Num109SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return new TreeNode(head.val);
        }
        ListNode preMid = preMid(head);
        TreeNode root = new TreeNode(preMid.next.val);
        root.right = sortedListToBST(preMid.next.next);
        preMid.next.next = null;
        preMid.next = null;
        root.left = sortedListToBST(head);
        return root;
    }
    private ListNode preMid(ListNode head){
        ListNode fast = head.next.next, slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
