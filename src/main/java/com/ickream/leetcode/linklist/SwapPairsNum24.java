package com.ickream.leetcode.linklist;

/**
 * Created by xf on 2017/11/29.
 * For example,
 *  Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapPairsNum24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode dummy= new ListNode(0);
        dummy.next = head;
        ListNode preCur=dummy;
        ListNode cur;
        ListNode next;
        while (preCur.next!=null&&preCur.next.next!=null){
            cur = preCur.next;
            next = cur.next;
            preCur.next=next;
            cur.next=next.next;
            next.next=cur;

            preCur=cur;
        }
        return dummy.next;
    }
}
