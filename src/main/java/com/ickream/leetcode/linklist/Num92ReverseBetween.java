package com.ickream.leetcode.linklist;

/**
 * Created by xf on 2017/12/12.
 * 翻转制定序号的之间的链表
 */
public class Num92ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next ==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy, preM;
        for(int i=1; i<m; i++){
            cur = cur.next;
        }
        preM = cur;
        cur = cur.next;
        for(int i=1; i<=n-m; i++){
            ListNode tmp = preM.next;
            preM.next = cur.next;
            cur.next = cur.next.next;
            preM.next.next = tmp;
        }
        return dummy.next;
    }
}
