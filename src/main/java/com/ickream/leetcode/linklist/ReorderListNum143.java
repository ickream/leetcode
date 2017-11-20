package com.ickream.leetcode.linklist;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xf on 2017/11/17.
 */
public class ReorderListNum143 {
    /**
     * 方法一 将链表插入到一个LinkedList列表中，然后交替将列表首尾相连
     * 这个方法不好因为借助一个LinkedList列表才实现功能
     * @param head
     */
    public void reorderList(ListNode head) {
        if(head==null){
            return ;
        }
        ListNode next=head;
        LinkedList<ListNode> list=new LinkedList<>();
        while (next!=null){
            list.addLast(next);
            next=next.next;
        }
        next=list.removeFirst();
        while(list.size()>0){
            next.next=list.removeLast();
            next=next.next;
            if(list.size()==0){
                next.next=null;
                break;
            }
            next.next=list.removeFirst();
            next=next.next;
        }
        next.next=null;
    }

    /**
     * 方法二 每次得到尾节点的前一个节点，然后将尾节点插入到first节点后面，将first节点的next节点插入到尾节点后，将next节点设为first节点
     *
     * @param head
     */
    public void recordList2(ListNode head){
        if(head==null||head.next==null||head.next.next==null){
            return ;
        }
        ListNode first=head;
        ListNode beforeLast =getBeforeLastNode(head);
        while(first!=beforeLast){
            beforeLast.next.next=first.next;
            first.next=beforeLast.next;
            beforeLast.next=null;
            first=first.next.next;
            beforeLast=getBeforeLastNode(first);
        }

    }
    private ListNode getBeforeLastNode(ListNode head){
        ListNode next=head;
        if(next.next==null){
            return next;
        }
        while(next.next.next!=null){
            next=next.next;
        }
        return next;
    }

    public ListNode getListNode(int [] arr){
        ListNode head=new ListNode(arr[0]);
        ListNode next=head;
        for(int i=1;i<arr.length;i++){
            ListNode node=new ListNode(arr[i]);
            next.next=node;
            next=next.next;
        }
        return head;
    }
    public static void main(String []args){
        ReorderListNum143 re=new ReorderListNum143();
        ListNode head=re.getListNode(new int[]{1,2,3});
        ListNode next=head;
        while (next!=null){
            System.out.println(next.val+"");
            next=next.next;
        }
        re.reorderList(head);
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}