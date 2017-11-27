package com.ickream.leetcode.sort;

import com.ickream.leetcode.ListNode;

/**
 * Created by xf on 2017/11/27.
 * 合并两个有序链表，归并排序链表的一部分
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode cur=head;
        while(l1!=null||l2!=null){
            if(l1==null||l2==null){
                cur.next=l1==null?l2:l1;
                break;
            }
            if(l1.val>l2.val){
                cur.next=l1;
                cur=cur.next;
                l1=l1.next;
            }else{
                cur.next=l2;
                cur=cur.next;
                l2=l2.next;
            }
        }
        return head.next;
    }
}
