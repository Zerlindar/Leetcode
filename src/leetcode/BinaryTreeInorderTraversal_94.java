package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sunyongfeng on 2017/7/3.
 */
public class BinaryTreeInorderTraversal_94 {

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(null == root){
            return res;
        }
        if(null != root.left){
            res.addAll(inorderTraversal(root.left));
        }
        res.add(root.val);
        if(null != root.right){
            res.addAll(inorderTraversal(root.right));
        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(null == root){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode cur = root.left;
        while(null != cur || !stack.isEmpty()){
            while(null != cur){
                stack.add(cur);
                cur = cur.left;
            }
            if(!stack.isEmpty()){
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                cur = tmp.right;
            }
        }
        return res;

    }



    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
}


/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
 */