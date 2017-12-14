package com.ickream.leetcode.linklist;

/**
 * Created by xf on 2017/12/1.
 * 将重复节点只留下一个
 * 生成一个新的链表
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

    /**
     * 方法二
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if(head == null ||head.next == null){
            return head;
        }
        ListNode cur = head;
        while(cur.next != null){
            if(cur.val != cur.next.val){
                cur = cur.next;
                continue;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
