package leetcode;

/**
 * Created by sunyongfeng on 2017/6/20.
 */
public class PartitionList_86 {

    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null;
        ListNode rightHead = null;
        ListNode leftCur = null;
        ListNode rightCur = null;
        ListNode cur = head;
        while(null != cur){
            ListNode tmp = cur.next;
            cur.next = null;
            if(cur.val < x){
                if(leftHead == null){
                    leftHead = cur;
                }else{
                    leftCur.next = cur;
                }
                leftCur = cur;
            }else{
                if(rightHead == null){
                    rightHead = cur;
                }else{
                    rightCur.next = cur;
                }
                rightCur = cur;
            }
            cur = tmp;
        }
        if(null == leftHead){
            return rightHead;
        }else if(null == rightHead){
            return leftHead;
        }else{
            leftCur.next = rightHead;
            return leftHead;
        }
    }




    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }

    }


    public static void main(String[] args) {
        PartitionList_86 partitionList_86 = new PartitionList_86();
        PartitionList_86.ListNode listNode = partitionList_86.new ListNode(2);
        listNode.next= partitionList_86.new ListNode(1);

        System.out.println(partitionList_86.partition(listNode,2));
    }
}


/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

Subscribe to see which companies asked this question.
 */