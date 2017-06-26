package leetcode;

/**
 * Created by yongfeng on 17/4/18.
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal_106 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        if(0 == len){
            return null;
        }
        TreeNode node = buildHelper(inorder, 0, len - 1, postorder, 0, len - 1);
        return node;
    }

    private TreeNode buildHelper(int[] inorder,int inorderStart,int inorderStop,int[] postorder,int postorderStart ,int postorderStop){
        if(inorderStart > inorderStop){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorderStop]);
        int i = 0 ;
        while(i + inorderStart <= inorderStop && inorder[i + inorderStart] != postorder[postorderStop]){
            ++i;
        }
        root.left = buildHelper(inorder, inorderStart, inorderStart + i - 1, postorder, postorderStart, postorderStart + i - 1);
        root.right = buildHelper(inorder,inorderStart + i + 1,inorderStop,postorder,postorderStart + i,postorderStop - 1);
        return root;
    }


    public static void main(String[] args) {
        int[] inorder = {5,1,9,4,6,2,8,3,7,10};
        int[] postorder = {5,9,6,4,1,8,10,7,3,2};
        ConstructBinaryTreefromInorderandPostorderTraversal_106 constructBinaryTreefromInorderandPostorderTraversal_106 = new ConstructBinaryTreefromInorderandPostorderTraversal_106();
        constructBinaryTreefromInorderandPostorderTraversal_106.buildTree(inorder,postorder);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

    /*
    Given inorder and postorder traversal of a tree, construct the binary tree.
    Note:
    You may assume that duplicates do not exist in the tree.
     */


