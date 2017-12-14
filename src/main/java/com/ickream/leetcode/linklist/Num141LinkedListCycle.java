package com.ickream.leetcode.linklist;

/**
 * Created by xf on 2017/12/13.
 * 验证链表是否成环
 */
public class Num141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){    //记住这种写法，，，
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }
}
