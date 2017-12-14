package com.ickream.leetcode.linklist;

/**
 * Created by xf on 2017/12/1.
 * 去除链表中重复的节点只留下不同的节点
 * 思路是只取不同点生成一个新的链表
 */
public class Num82DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curNode = head;
        ListNode next = dummy;
        int count = 1;
        while (curNode.next != null){
            if(curNode.val == curNode.next.val){
                count++;
                curNode = curNode.next;
                continue;
            }
            if(count == 1){
                next.next = curNode;
                next = next.next;
            }else{
                count = 1;
            }
            curNode = curNode.next;
        }
        next.next = count==1 ? curNode : null;
        return dummy.next;
    }
//    public ListNode deleteDuplicates2(ListNode head) {
//        if(head == null || head.next == null){
//            return head;
//        }
//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode preCur = dummy;
//        ListNode cur = head;
//        while(cur)
//    }
}
