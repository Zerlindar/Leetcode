package leetcode;

import java.util.*;

/**
 * Created by sunyongfeng on 2017/7/25.
 */
public class ValidTriangleNumber_611 {
    public int triangleNumber(int[] nums) {
        int res = 0 ;
        if(null == nums){
            return res ;
        }
        int len = nums.length;
        if(len < 3){
            return res;
        }
        Arrays.sort(nums);
        for(int i = len - 1; i >= 2 ; --i){
            int left = 0 ;
            int right = i - 1;
            while(left < right){
                if(nums[left] + nums[right] > nums[i]){
                    res += (right - left);
                    --right;
                }else{
                    ++left;
                }
            }
        }
        return res;

    }


    public static void main(String[] args) {
        ValidTriangleNumber_611 validTriangleNumber_611 = new ValidTriangleNumber_611();
        System.out.println(validTriangleNumber_611.triangleNumber(new int[]{2,2,3,4}));
    }
}


/*
Given an array consists of non-negative integers,
your task is to count the number of triplets chosen from the array that can make triangles
if we take them as side lengths of a triangle.

Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are:
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Note:
The length of the given array won't exceed 1000.
The integers in the given array are in the range of [0, 1000].


 */