package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * Created by sunyongfeng on 2017/7/5.
 */
public class MostFrequentSubtreeSum_508 {

    public int[] findFrequentTreeSum(TreeNode root) {
        int[] res ;
        List<Integer> tmp = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        helper(root,map);
        int max = 0;
        Set<Map.Entry<Integer,Integer>> entrySet = map.entrySet();
        for(Map.Entry<Integer,Integer> entry : entrySet){
            if(entry.getValue() > max){
                max = entry.getValue();
            }
        }
        for(Map.Entry<Integer,Integer> entry : entrySet){
            if(entry.getValue() == max){
                tmp.add(entry.getKey());
            }
        }
        res = new int[tmp.size()];
        for(int i = 0 ; i < tmp.size() ; ++i){
            res[i] = tmp.get(i);
        }
        return res;
    }

    private int helper(TreeNode root, Map<Integer,Integer> map){
        if(null == root){
            return 0;
        }
        if(null != root.left){
            root.val += helper(root.left, map);
        }
        if(null != root.right){
            root.val += helper(root.right,map);
        }
        map.merge(root.val, 1, (a, b) -> (a + b));
        return root.val;
    }


    public static void main(String[] args) {
        MostFrequentSubtreeSum_508 mostFrequentSubtreeSum_508 = new MostFrequentSubtreeSum_508();
        TreeNode treeNode = mostFrequentSubtreeSum_508.new TreeNode(5);
        TreeNode treeNode1 = mostFrequentSubtreeSum_508.new TreeNode(2);
        TreeNode treeNode2 = mostFrequentSubtreeSum_508.new TreeNode(-3);
        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
    }



    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}


/*
Given the root of a tree, you are asked to find the most frequent subtree sum.
The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted
at that node (including the node itself).
So what is the most frequent subtree sum value? If there is a tie,
return all the values with the highest frequency in any order.

Examples 1
Input:

  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.
Examples 2
Input:

  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
 */