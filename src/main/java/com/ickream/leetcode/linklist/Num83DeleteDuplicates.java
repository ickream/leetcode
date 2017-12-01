package com.ickream.leetcode.linklist;

/**
 * Created by xf on 2017/12/1.
 */
public class Num83DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null ||head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);

        ListNode cur = head;
        ListNode next = dummy;
        while(cur.next != null){
            if(cur.val != cur.next.val){
                next.next = cur;
                next = next.next;
            }
            cur = cur.next;
        }
        next.next = cur;
        return dummy.next;
    }
}
