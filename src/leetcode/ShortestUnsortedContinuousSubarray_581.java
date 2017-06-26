package leetcode;

import java.util.Arrays;

/**
 * Created by sunyongfeng on 2017/6/6.
 */
public class ShortestUnsortedContinuousSubarray_581 {

    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return 0;
        }
        int[] tmp = new int[len];
        for(int i = 0 ; i < len ; ++i){
            tmp[i] = nums[i];
        }
        Arrays.sort(tmp);
        int i = 0;
        int j = len -1;
        while(i < len && nums[i] == tmp[i]){
            ++i;
        }
        while(j > i && nums[j] == tmp[j]){
            --j;
        }
        return j - i + 1;
    }

    public static void main(String[] args) {
        ShortestUnsortedContinuousSubarray_581 shortestUnsortedContinuousSubarray_581 = new ShortestUnsortedContinuousSubarray_581();
        int[] nums = {1,2,34};
        System.out.println(shortestUnsortedContinuousSubarray_581.findUnsortedSubarray(nums));
    }


}


/*
Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Note:
Then length of the input array is in range [1, 10,000].
The input array may contain duplicates, so ascending order here means <=.
Subscribe to see which companies asked this question.
 */