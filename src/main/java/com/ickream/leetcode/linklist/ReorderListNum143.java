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
    public void reorderList2(ListNode head){
        if(head==null||head.next==null||head.next.next==null){
            return ;
        }
        ListNode first=head;
        ListNode preLast =getPreLastNode(head);
        while(first!=preLast){
            preLast.next.next=first.next;
            first.next=preLast.next;
            preLast.next=null;
            first=first.next.next;
            preLast=getPreLastNode(first);
        }

    }
    private ListNode getPreLastNode(ListNode head){
        ListNode next=head;
        if(next.next==null){
            return next;
        }
        while(next.next.next!=null){
            next=next.next;
        }
        return next;
    }

    /**
     * 最好的方法 快慢指针找到中间节点 然后反转后半部分 然后插入
     * @param head
     */
    public void reorderList3(ListNode head){
        if(head==null||head.next==null||head.next.next==null){
            return ;
        }
        ListNode preMidNode=head;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){  //快慢指针
            preMidNode=slow;
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode cur=preMidNode.next;         //反转链表
        while(cur!=null&&cur.next!=null){
            ListNode tmp=cur.next;
            cur.next=tmp.next;
            tmp.next=preMidNode.next;
            preMidNode.next=tmp;
        }

        cur=head;
        ListNode midNext=preMidNode.next;
        preMidNode.next=null;
        while(true){
            if(cur.next==null){
                cur.next=midNext;
                break;
            }
            ListNode tmp=midNext.next;
            midNext.next=cur.next;
            cur.next=midNext;
            midNext=tmp;
            cur=cur.next.next;
        }
    }
    private ListNode getPreMidNode(ListNode head){
        ListNode preMidNode=head;
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            preMidNode=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        return preMidNode;
    }
    private ListNode reverseListNode(ListNode head){
        ListNode newHead=new ListNode(0);
        ListNode next;
        while(head!=null){
            next=head.next;
            head.next=newHead.next;
            newHead.next=head;
            head=next;
        }
        return newHead.next;
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