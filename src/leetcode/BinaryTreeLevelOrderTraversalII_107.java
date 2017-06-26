package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yongfeng on 17/4/10.
 */
public class BinaryTreeLevelOrderTraversalII_107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        helper(res,root,0);
        return res;
    }

    private void helper(List<List<Integer>> res,TreeNode root,int level){
        if(null == root){
            return ;
        }
        if(level > res.size() - 1){
            res.add(0,new ArrayList<Integer>());
        }
        res.get(res.size() - 1 - level).add(root.val);

        helper(res, root.left, level + 1);
        helper(res,root.right,level + 1);
    }




      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

}
/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
Subscribe to see which companies asked this question.
 */

