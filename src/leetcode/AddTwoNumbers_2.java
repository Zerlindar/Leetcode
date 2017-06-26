package leetcode;

/**
 * Created by sunyongfeng on 2017/6/23.
 */
public class AddTwoNumbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode res = new ListNode(0);
        ListNode cur = res;
        Integer flag = 0;
        while(null != cur1 && null != cur2){
            ListNode tmp = new ListNode((cur1.val + cur2.val + flag) % 10);
            cur.next = tmp;
            cur = tmp;
            flag = (cur1.val + cur2.val + flag ) / 10;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while(null != cur1){
            ListNode tmp = new ListNode((cur1.val + flag) % 10);
            cur.next = tmp;
            cur = tmp;
            flag = (cur1.val + flag) / 10;
            cur1 = cur1.next;
        }
        while(null != cur2){
            ListNode tmp = new ListNode((cur2.val + flag) % 10);
            cur.next = tmp;
            cur = tmp;
            flag = (cur2.val + flag) / 10;
            cur2 = cur2.next;
        }
        if(flag != 0){
            ListNode tmp = new ListNode(flag);
            cur.next = tmp;
        }

        return res.next;
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
 }
}


/**
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8



*/