package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yongfeng on 17/4/12.
 */
public class SymmetricTree_101 {

    public boolean isSymmetric(TreeNode root) {
        if(null == root || (null == root.left && null == root.right)){
            return true;
        }
        if((null != root.left && null == root.right) || (null == root.left && null != root.right)){
            return false;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while(!deque.isEmpty()){
            TreeNode node1 = deque.pollFirst();
            TreeNode node2 = deque.pollLast();
            if(null == node1 || null == node2 || node1.val != node2.val){
                return false;
            }
            if((null != node1.left  && null == node2.right ) || (null != node1.right && null == node2.left) || (null == node1.left && null != node2.right ) || (null == node1.right  && null != node2.left )){
                return false;
            }
            if(null != node1.left && null != node2.right){
                deque.offerFirst(node1.left);
                deque.offerLast(node2.right);
            }
            if(null != node1.right && null != node2.left){
                deque.offerFirst(node1.right);
                deque.offerLast(node2.left);
            }
        }
        return true;
    }




    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        TreeNode node3 = new TreeNode(2);
        node1.right = node3;
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        SymmetricTree_101 symmetricTree_101 = new SymmetricTree_101();
        System.out.println(symmetricTree_101.isSymmetric(node1));
    }



      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

}

/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

Subscribe to see which companies asked this question.
 */