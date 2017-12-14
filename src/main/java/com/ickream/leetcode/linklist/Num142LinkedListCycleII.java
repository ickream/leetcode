package com.ickream.leetcode.linklist;

/**
 * Created by xf on 2017/12/13.
 * Given a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 */
public class Num142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){    //记住这种写法，，，
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                break;
            }
        }
        if(fast==null || fast.next==null){
            return null;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
    /**
     * 方法二 将所有的节点都放入一个set中，成环点在第二次访问时返回
     * 会利用外部空间
     */
}
