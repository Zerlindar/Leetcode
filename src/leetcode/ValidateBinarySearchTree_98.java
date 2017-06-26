package leetcode;

/**
 * Created by yongfeng on 17/4/17.
 */
public class ValidateBinarySearchTree_98 {

    public boolean isValidBST(TreeNode root) {
        return helper(root,(long)Integer.MIN_VALUE - 1,(long)Integer.MAX_VALUE + 1);
    }

    private boolean helper(TreeNode node ,Long min,Long max){
        if(null == node){
            return true;
        }
        long mid = node.val;
        if(mid < min || mid > max){
            return false;
        }
        return helper(node.left,min,mid) && helper(node.right,mid,max);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2147483647);
        ValidateBinarySearchTree_98 validateBinarySearchTree_98 = new ValidateBinarySearchTree_98();
        validateBinarySearchTree_98.isValidBST(treeNode);
    }

    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

}
