package com.ickream.leetcode.linklist;


import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xf on 2017/11/17.
 */
public class ReorderListNum143 {
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