package leetcode;

/**
 * Created by sunyongfeng on 2017/6/22.
 */
public class RemoveDuplicatesfromSortedList_83 {

    public ListNode deleteDuplicates(ListNode head) {
        if(null == head){
            return null;
        }
        ListNode cur = head;
        ListNode tmp = null;
        while(cur!= null){
            tmp = cur.next;
            while(tmp != null && tmp.val == cur.val){
                tmp = tmp.next;
            }
            cur.next = tmp;
            cur = tmp;
        }

        return head;
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

}


/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */