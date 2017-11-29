package com.ickream.leetcode.linklist;

/**
 * Created by xf on 2017/11/29.
 */
public class RotateRightNum61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0||head==null||head.next==null){
            return head;
        }
        ListNode dummy= new ListNode(0);
        dummy.next=head;
        ListNode cur=head;
        ListNode nextCur=head;
        int len = 1;
        while(cur.next !=null){
            len++;
            cur = cur.next;
        }
        int i = 1;
        while(i<len-k%len){     //
            nextCur = nextCur.next;
            i++;
        }
        cur.next = dummy.next;
        dummy.next = nextCur.next;
        nextCur.next = null;
        return dummy.next;
    }
}
