package leetcode;

import java.util.HashMap;

/**
 * Created by yongfeng on 17/4/25.
 */
public class ContinuousSubarraySum_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            Integer prev = map.get(k == 0 ? sum : sum % k);
            if (prev != null) {
                if (i - prev > 1) {
                    return true;
                }
            } else {
                map.put(k == 0 ? sum : sum % k, i);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1,1000000000};
        ContinuousSubarraySum_523 continuousSubarraySum_523 = new ContinuousSubarraySum_523();
        boolean res = continuousSubarraySum_523.checkSubarraySum(nums,1);
        System.out.println(res);
    }
}


/*
Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.

Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
Note:
The length of the array won'SkipList exceed 10,000.
You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */