package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by yongfeng on 17/4/13.
 */
public class FindBottomLeftTreeValue_513 {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int res = root.val;
        while(!queue.isEmpty()){
            int sum = queue.size();
            while(sum > 0 ){
                TreeNode node = queue.poll();
                if(null != node.right){
                    queue.offer(node.right);
                }
                if(null != node.left){
                    queue.offer(node.left);
                }
                res = node.val;
                --sum ;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        treeNode.left = node1;
        treeNode.right = node2;
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node6;
        FindBottomLeftTreeValue_513 findBottomLeftTreeValue_513 = new FindBottomLeftTreeValue_513();
        System.out.println(findBottomLeftTreeValue_513.findBottomLeftValue(treeNode));
    }


    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}


/*
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2:
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.
 */