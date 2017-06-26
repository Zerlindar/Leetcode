package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yongfeng on 16/12/28.
 */



//Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
//
//        For example,
//        Given n = 3, your program should return all 5 unique BST's shown below.
//
//        1         3     3      2      1
//        \       /     /      / \      \
//        3     2     1      1   3      2
//        /     /       \                 \
//        2     1         2                 3
//        Subscribe to see which companies asked this question

//Input:
//        3
//        Output:
//        [[1,null,2,null,3],[1,null,3,3],[2,3,3,3,null,null,3],[3,2,null,null,3],[3,3,null,3]]
//        Expected:
//        [[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]



public class UniqueBinarySearchTreesII_95 {


    public   List<TreeNode> generateTrees(int n) {
        Map<Integer,List<TreeNode>> treeNodeMap = new HashMap<>();
        TreeNode t1 = new TreeNode(1);
        List<TreeNode> l1 = new ArrayList<>();
        l1.add(t1);
        treeNodeMap.put(1, l1);
        treeNodeMap.put(0,new ArrayList<TreeNode>());

        for(int i = 2 ; i <= n ; ++i){
            List<TreeNode> tmp = new ArrayList<>();
            for(int j = 1 ; j <= i ; ++j ){
                tmp.addAll(mergeTreeNodeList(i, j, treeNodeMap));
            }
            treeNodeMap.put(i,tmp);
        }

        return treeNodeMap.get(n);

    }


    private  List<TreeNode> mergeTreeNodeList(int max,int val,Map<Integer,List<TreeNode>> treeNodeMap){
        int left = val - 1;
        int right = max -1 - left;
        List<TreeNode> leftList = treeNodeMap.get(left);
        List<TreeNode> rightList = treeNodeMap.get(right);

        List<TreeNode> res = new ArrayList<>();

        List<TreeNode> tmpLeft = new ArrayList<>();

        List<TreeNode> tmpRight = new ArrayList<>();



        for(TreeNode t : leftList){
            TreeNode newNode = new TreeNode(val);
            newNode.left = generateTreeNode(t,0);
            tmpLeft.add(newNode);
        }


        for(TreeNode t : rightList){
            TreeNode newNode = new TreeNode(val);
            newNode.right = generateTreeNode(t,val);
            tmpRight.add(newNode);
        }

        if(tmpLeft.size() == 0 ){
            return tmpRight;
        }

        if(tmpRight.size() == 0){
            return tmpLeft;
        }

        for(TreeNode leftNode : tmpLeft){
            for(TreeNode rightNode : tmpRight){
                TreeNode newNode = new TreeNode(val);
                newNode.left = leftNode.left;
                newNode.right = rightNode.right;
                res.add(newNode);
            }
        }

        return res;


    }


    private  TreeNode generateTreeNode(TreeNode originNode ,int incr){
        if(null == originNode){
            return null;
        }
        TreeNode newNode = new TreeNode(originNode.val + incr);
        newNode.left = generateTreeNode(originNode.left,incr);
        newNode.right = generateTreeNode(originNode.right,incr);

        return newNode;
    }


    public static void main(String[] args) {
        UniqueBinarySearchTreesII_95 uniqueBinarySearchTreesII_95 = new UniqueBinarySearchTreesII_95();
        List<TreeNode> res = uniqueBinarySearchTreesII_95.generateTrees(3);

        for(TreeNode treeNode : res){
            output(treeNode);
            System.out.println("");
        }

        System.out.println(res.size());
    }



    private static void output(TreeNode treeNode){
        if(null == treeNode){
            return ;
        }
        System.out.print("    " + treeNode.val);
        output(treeNode.left);
        output(treeNode.right);
    }



   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

}
