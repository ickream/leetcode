package com.ickream.leetcode.linklist;

import com.ickream.leetcode.GenerateLinkList;
import com.ickream.leetcode.ListNode;
import java.util.List;

/**
 * Created by xf on 2017/12/1.
 */
public class Num86Partition {
    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode oldDummy =new ListNode(0);
        ListNode preCur = oldDummy;
        oldDummy.next = head;
        ListNode newDummy = new ListNode(0);
        ListNode next =newDummy ;

        while(preCur.next !=null){
            if(preCur.next.val < x){
                next.next = preCur.next;
                preCur.next = preCur.next.next;
                next = next.next;
                continue;
            }
            preCur = preCur.next;
        }
        next.next = oldDummy.next;
        return newDummy.next;
    }

    public static void main(String [] args){
        ListNode head= GenerateLinkList.getLinkList(new int[] {1,4,3,2,5,2});
        partition(head,3);

    }
}
