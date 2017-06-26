package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yongfeng on 17/1/9.
 */


//Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies: Si % Sj = 0 or Sj % Si = 0.
//
//        If there are multiple solutions, return any subset is fine.
//
//        Example 1:
//
//        nums: [1,2,3]
//
//        Result: [1,2] (of course, [1,3] will also be ok)
//        Example 2:
//
//        nums: [1,2,4,8]
//
//        Result: [1,2,4,8]
//        Credits:
//        Special thanks to @Stomach_ache for adding this problem and creating all test cases.
//
//        Subscribe to see which companies asked this question



public class LargestDivisibleSubset_368 {


    /**
     *
     * @param nums
     * @return
     */
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if(len == 0){
            return res;
        }

        Arrays.sort(nums);

        int[] result = new int[len];
        int[] cnt = new int[len];
        for(int i = 0 ; i < len ; ++i){
            result[i] = 1;
            cnt[i] = -1;
        }

        int maxLen = 1;
        int maxIndex = 0;
        for(int i = 1 ; i < len ; ++i){
            for(int j = 0 ; j < i ; ++j){
                if(nums[i] % nums[j] == 0 && result[j] + 1 > result[i]){
                    result[i] = result[j] + 1;
                    cnt[i] = j;

                }
            }
            if(result[i] > maxLen){
                maxLen = result[i];
                maxIndex = i;
            }

        }

        while(maxIndex != -1){
            res.add(nums[maxIndex]);
            maxIndex = cnt[maxIndex];
        }

        Collections.reverse(res);

        return res;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2,3,4,5,9,7,18};
        List<Integer> res = largestDivisibleSubset(nums);
        for(Integer tmp : res){
            System.out.println(tmp);
        }
    }


}
