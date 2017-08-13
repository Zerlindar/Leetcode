package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sunyongfeng on 2017/7/4.
 */
public class InvertBinaryTree_226 {

    public TreeNode invertTree2(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree2(right);
        root.right = invertTree2(left);
        return root;
    }


    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode head = queue.poll();
            TreeNode left = head.left;
            head.left = head.right;
            head.right = left;
            if(null != head.left){
                queue.add(head.left);
            }
            if(null != head.right){
                queue.add(head.right);
            }
        }
        return root;
    }


    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }


}


/*
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:
Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so fuck off.

 */