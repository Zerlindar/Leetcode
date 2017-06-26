package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunyongfeng on 2017/6/14.
 */
public class FindAllDuplicatesinanArray_442 {


    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(null == nums){
            return res;
        }
        int len = nums.length;
        int[] cnt = new int[len + 1];
        for(int num : nums){
            ++cnt[num];
        }
        for(int i = 0 ; i <= len ; ++i){
            if(cnt[i] == 2){
                res.add(i);
            }
        }
        return res;
    }



}

/*

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 */
