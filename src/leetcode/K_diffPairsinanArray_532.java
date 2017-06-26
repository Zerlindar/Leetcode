package leetcode;

import java.util.Arrays;

/**
 * Created by sunyongfeng on 2017/6/5.
 */
public class K_diffPairsinanArray_532 {

    public int findPairs(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        if(len < 2){
            return res;
        }
        Arrays.sort(nums);
        if(k < 0){
            return 0;
        }
        if(k == 0){
            for(int i = 0 ; i + 1 < len ;++i){
                if(nums[i] == nums[i + 1]){
                    ++res;
                    while (i + 1 < len && nums[i] == nums[i+1]){
                        ++i;
                    }
                }
            }
            return res;
        }
        for(int i = 0 ,j = 1 ; i + 1 < len ; ++i){
            if(nums[i] == nums[i + 1]){
                continue;
            }
            for(; j < len ; ++j){
                if(nums[j] - nums[i] > k){
                    break;
                }
                if(nums[j] - nums[i] == k){
                    ++res;
                    ++j;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        K_diffPairsinanArray_532 k_diffPairsinanArray_532 = new K_diffPairsinanArray_532();
        int[] nums = {6,3,5,7,2,3,3,8,2,4};
        System.out.println(k_diffPairsinanArray_532.findPairs(nums,2));
    }
}


/*
Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
Here a k-diff pair is defined as an integer pair (i, j),
where i and j are both numbers in the array and their absolute difference is k.

Example 1:
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
Example 2:
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
Example 3:
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
Note:
The pairs (i, j) and (j, i) count as the same pair.
The length of the array won'SkipList exceed 10,000.
All the integers in the given input belong to the range: [-1e7, 1e7].
Subscribe to see which companies asked this question.
 */
