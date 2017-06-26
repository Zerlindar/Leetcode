package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yongfeng on 17/5/11.
 */
public class IncreasingSubsequences_491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> tmp = new ArrayList<>();
        helper(res,tmp,nums,0,nums.length - 1);
        return new ArrayList<>(res);
    }

    private void helper(Set<List<Integer>> res ,List<Integer> tmp,int[] nums,int start,int end){
        if(tmp.size() > 1){
            res.add(new ArrayList<Integer>(tmp));
        }
        for(int i = start ; i <= end; ++i){
            if(tmp.size() == 0 || nums[i] >= tmp.get(tmp.size() - 1)){
                tmp.add(nums[i]);
                helper(res, tmp, nums, i + 1, end);
                tmp.remove(tmp.size() - 1);
            }
        }
    }



    public static void main(String[] args) {
        IncreasingSubsequences_491 increasingSubsequences_491 = new IncreasingSubsequences_491();
        int[] nums = {4,6,7,7};
        List<List<Integer>> res = increasingSubsequences_491.findSubsequences(nums);

        System.out.println(res);
    }



}


/*
Given an integer array, your task is to find all the different possible increasing subsequences of the given array,
and the length of an increasing subsequence should be at least 2 .

Example:
Input: [4, 6, 7, 7]
Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
Note:
The length of the given array will not exceed 15.
The range of integer in the given array is [-100,100].
The given array may contain duplicates, and two equal integers should also be considered as a special case of increasing sequence.
 */
