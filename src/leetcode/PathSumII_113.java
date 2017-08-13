package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by sunyongfeng on 2017/6/28.
 */
public class PathSumII_113 {

    public List<List<Integer>> pathSum(TreeNode root, int sum){
        List<List<TreeNode>> res = new ArrayList<>();
        List<List<Integer>> resList = new ArrayList<>();
        if(null == root){
            return resList;
        }
        Stack<TreeNode> tmp = new Stack<>();
        helper(root,sum,0,res,tmp);
        for(List<TreeNode> treeNodeList : res){
            List<Integer> list = new ArrayList<>();
            for(TreeNode treeNode : treeNodeList){
                list.add(treeNode.val);
            }
            resList.add(list);
        }
        return resList;
    }

    private void helper(TreeNode treeNode,int target,int curSum,List<List<TreeNode>> res,Stack<TreeNode> stack){
        if(null == treeNode){
            return ;
        }
        curSum += treeNode.val;
        stack.push(treeNode);
        boolean isLeaf = (null == treeNode.right) && (null == treeNode.left);
        if(curSum == target && isLeaf){
            res.add(stack2List(stack));
        }
        if(null != treeNode.left){
            helper(treeNode.left,target,curSum,res,stack);
        }
        if(null != treeNode.right){
            helper(treeNode.right,target,curSum,res,stack);
        }
        stack.pop();
    }

    private List<TreeNode> stack2List(Stack<TreeNode> stack){
        List<TreeNode> res = new ArrayList<>();
        if(null == stack){
            return res;
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        Collections.reverse(res);
        for(TreeNode treeNode : res){
            stack.push(treeNode);
        }
        return res;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}


/**
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]

 */