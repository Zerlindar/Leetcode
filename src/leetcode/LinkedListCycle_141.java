package leetcode;

/**
 * Created by sunyongfeng on 2017/6/19.
 */
public class LinkedListCycle_141 {

    public boolean hasCycle(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while(null != quick && null != slow && null != quick.next){
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow){
                return true;
            }
        }
        return false;
    }



    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


}

/**
 * Given a linked list, determine if it has a cycle in it.

 Follow up:
 Can you solve it without using extra space?
 */
