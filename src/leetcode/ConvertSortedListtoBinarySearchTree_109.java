package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunyongfeng on 2017/6/21.
 */
public class ConvertSortedListtoBinarySearchTree_109 {

    public TreeNode sortedListToBST(ListNode head) {
        if(null == head){
            return  null;
        }
        int len = 0;
        List<ListNode> listNodeList = new ArrayList<>();
        ListNode cur = head;
        while(null != cur){
            ++len;
            listNodeList.add(cur);
            cur = cur.next;
        }
        return build(listNodeList,0,len - 1 );
    }

    private TreeNode build(List<ListNode> listNodeList,int start,int end){
        if(start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode treeNode = new TreeNode(listNodeList.get(mid).val);
        if(start <  end) {
            treeNode.left = build(listNodeList,start,mid - 1);
            treeNode.right = build(listNodeList,mid + 1,end);
        }
        return treeNode;
    }


    public static void main(String[] args) {
        ConvertSortedListtoBinarySearchTree_109 convertSortedListtoBinarySearchTree = new ConvertSortedListtoBinarySearchTree_109();
        ListNode listNode = convertSortedListtoBinarySearchTree.new ListNode(1);
        listNode.next= convertSortedListtoBinarySearchTree.new ListNode(3);

        System.out.println(convertSortedListtoBinarySearchTree.sortedListToBST(listNode));
    }



      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }



  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}


/**
 Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

*/