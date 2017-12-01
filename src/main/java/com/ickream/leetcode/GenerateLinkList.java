package com.ickream.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by xf on 2017/11/21.
 */
public class GenerateLinkList {
    public static ListNode getLinkList(int [] arr){
        ListNode head=new ListNode(arr[0]);
        ListNode next=head;
        for(int i=1;i<arr.length;i++){
            ListNode node=new ListNode(arr[i]);
            next.next=node;
            next=next.next;
        }
        return head;
    }
    public static Integer[] getValue(ListNode head){
        List<Integer> integers=new ArrayList<>();
        while(head!=null){
            integers.add(head.val);
            head=head.next;
        }
        Integer [] arr=new Integer[integers.size()];
        arr=integers.toArray(arr);
        return arr;
    }
}
