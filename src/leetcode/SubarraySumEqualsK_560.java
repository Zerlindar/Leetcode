package leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sunyongfeng on 2017/7/27.
 */
public class SubarraySumEqualsK_560 {


    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0 ;
        int res = 0;
        map.put(0,1);
        for(Integer num : nums){
            sum += num;
            res += map.getOrDefault(sum - k,0);
            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return res;
    }



    public int subarraySum2(int[] nums, int k) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int[] sum = new int[len];
        sum[0] = nums[0];
        int res = nums[0] == k ? 1 : 0;
        for(int i = 1 ; i < len ; ++i){
            sum[i] = sum[i - 1] + nums[i];
            if(nums[i] == k){
                ++res;
            }
            if(sum[i] == k){
                ++res;
            }
        }
        for(int i = 1 ; i < len ; ++i){
            for(int j = i + 1; j < len ; ++j){
                if(sum[j] - sum[i - 1] == k){
                    ++ res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK_560 subarraySumEqualsK_560 = new SubarraySumEqualsK_560();
        System.out.println(subarraySumEqualsK_560.subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0},0));
    }
}


/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
[0,0,0,0,0,0,0,0,0,0]
0

 */