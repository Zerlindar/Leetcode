package leetcode;

/**
 * Created by yongfeng on 17/4/19.
 */
public class FlattenBinaryTreetoLinkedList_114 {
    public void flatten(TreeNode root) {
        if(null == root){
            return ;
        }
        flatten(root.left);
        flatten(root.right);
        if(null == root.left){
            return ;
        }
        TreeNode tmp = root.left;
        while(null != tmp.right){
            tmp = tmp.right;
        }
        tmp.right = root.right;
        root.right = root.left;
        root.left = null;
        return ;
    }

    public class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

}

/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 */