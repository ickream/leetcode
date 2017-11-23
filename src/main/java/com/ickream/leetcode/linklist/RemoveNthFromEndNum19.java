package com.ickream.leetcode.linklist;

import com.ickream.leetcode.ListNode;
import com.ickream.leetcode.GenerateLinkList;
/**
 * Created by xf on 2017/11/22.
 * Given a linked list, remove the nth node from the end of list and return its head.
 */
public class RemoveNthFromEndNum19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode node=new ListNode(0);     //头结点在很多时候很有用
        node.next=head;
        int i=0;
        ListNode cur =node;
        ListNode preNthNode=node;
        while(i<n){                             //cur节点先走，然后在让preNthNode节点走 受快慢指针启发
            cur=cur.next;
            i++;
        }
        while(cur!=null&&cur.next!=null){
            preNthNode=preNthNode.next;
            cur=cur.next;
        }
        cur=preNthNode.next;
        preNthNode.next=cur.next;
        cur.next=null;
        return node.next;
    }
}
