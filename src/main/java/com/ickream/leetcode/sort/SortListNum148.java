package com.ickream.leetcode.sort;

import java.util.Arrays;
import java.util.List;

import com.ickream.leetcode.GenerateLinkList;
import com.ickream.leetcode.ListNode;

/**
 * Created by xf on 2017/11/17.
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 在nlog(n)时间复杂度里排序先想到快排和归并排序 然后用归并排序
 */
public class SortListNum148 {
    public  ListNode sortList(ListNode head) {
        if(head==null|| head.next==null){
            return head;
        }
        ListNode preMidNode=getMidNode(head);      //快慢指针找到中间节点
        ListNode midNode=preMidNode.next;          //这里找到中间节点的前一个节点是为了分成两个链表后将前一个链表尾节点置空
        preMidNode.next=null;                      //将链表分成两个分别排序后再归并，注意将前半个链表尾节点置空
        ListNode newHead= sortList(head);
        ListNode newMidNode=sortList(midNode);
        return mergeList(newHead,newMidNode);
    }
    private ListNode getMidNode(ListNode head){  //研究下快慢指针//优化了一下
        ListNode fast=head.next.next;
        ListNode slow=head;
        while(fast!=null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private ListNode mergeList(ListNode listA,ListNode listB){
        ListNode head=new ListNode(0);
        ListNode next=head;
        while (true){
            if(listA == null||listB==null){
                next.next = listA==null? listB:listA;
                break;
            }
            if(listA.val<listB.val){
                next.next = listA;
                next=listA;
                listA=listA.next;
            }else {
                next.next = listB;
                next = listB;
                listB=listB.next;
            }
        }
        return head.next;
    }
    public static void main(String [] args){
        SortListNum148 sort=new SortListNum148();
        ListNode head=GenerateLinkList.getLinkList(new int[]{1,13,4});
        ListNode node= sort.sortList(head);
        System.out.println(Arrays.toString(GenerateLinkList.getValue(node)));
    }
}
