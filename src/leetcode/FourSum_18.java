package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yongfeng on 17/4/7.
 */
public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        if(len < 4){
            return res;
        }

        for(int i = 0 ; i < len ; ++i){
            for(int j = i + 1; j < len ; ++j ){
                twoNum(nums,target,i,j,res,len);
            }
        }

        return res;
    }

    public void twoNum(int[] nums,int target,int start,int end,List<List<Integer>> res,int len){
        if(end - start < 2 || start < 0 || end >= len){
            return;
        }
        if(nums[start] + nums[end] + nums[start + 1] + nums[start + 2] > target){
            return ;
        }else if(nums[start] + nums[end] + nums[end - 1] + nums[end - 2] < target){
            return ;
        }else{
            int left = start + 1;
            int right = end - 1;
            while (left < right){
                int sum = nums[start] + nums[end] + nums[left] + nums[right];
                if(sum == target){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[start]);
                    tmp.add(nums[end]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    Collections.sort(tmp);
                    if(!exits(res,tmp)){
                        res.add(tmp);
                    }
                    int num = nums[right--];
                    while(num == nums[right] && left < right){
                        -- right;
                    }
                }else if(sum < target){
                    ++ left;
                }else{
                    -- right;
                }
            }
        }
    }

    public boolean exits(List<List<Integer>> res ,List<Integer> tmp){
        if(res.size() == 0){
            return false;
        }
        for(List<Integer> list : res){
            int len = list.size();
            int i = 0;
            for(;i < len; ++i){
                if(!tmp.get(i).equals(list.get(i))){
                    break;
                }
            }
            if(i == len){
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        FourSum_18 fourSum_18 = new FourSum_18();
        int[] nums = {-5,-4,-3,-2,-1,0,0,1,2,3,4,5};
        System.out.println(fourSum_18.fourSum(nums,0));
    }
}

/*
[[-5,-4,4,5],[-5,-3,3,5],[-5,-2,2,5],[-5,-1,1,5],[-5,0,0,5],[-5,-2,3,4],[-5,-1,2,4],[-5,0,1,4],
[-4,-3,2,5],[-4,-2,1,5],[-4,-1,0,5],[-4,-3,3,4],[-4,-2,2,4],[-4,-1,1,4],[-4,0,0,4],[-4,-1,2,3],[-4,0,1,3],
[-3,-2,1,4],[-3,-1,0,4],[-3,-2,2,3],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],
[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],
[-1,0,0,1]]
 */

/*
[[-5,-4,4,5],[-5,-3,3,5],[-5,-2,2,5],[-5,-2,3,4],[-5,-1,1,5],[-5,-1,2,4],[-5,0,0,5],[-5,0,1,4],[-5,0,2,3],
[-4,-3,2,5],[-4,-3,3,4],[-4,-2,1,5],[-4,-2,2,4],[-4,-1,0,5],[-4,-1,1,4],[-4,-1,2,3],[-4,0,0,4],[-4,0,1,3],
[-3,-2,0,5],[-3,-2,1,4],[-3,-2,2,3],[-3,-1,0,4],[-3,-1,1,3],[-3,0,0,3],[-3,0,1,2],
[-2,-1,0,3],[-2,-1,1,2],[-2,0,0,2],
[-1,0,0,1]]
 */

/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note: The solution set must not contain duplicate quadruplets.

For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
Subscribe to see which companies asked this question.
 */