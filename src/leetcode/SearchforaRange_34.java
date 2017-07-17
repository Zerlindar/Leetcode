package leetcode;

/**
     * Created by sunyongfeng on 2017/7/17.
 */
public class SearchforaRange_34 {
    public int[] searchRange(int[] nums, int target) {
        int[] notFound = {-1,-1};
        if(null == nums){
            return notFound;
        }
        int len = nums.length;
        int right = len - 1;
        int left = 0 ;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                int tmp1 = mid;
                int tmp2 = mid;
                while(tmp1 >= 0 && nums[tmp1] == target){
                    --tmp1;
                }
                while(tmp2 < len && nums[tmp2] == target){
                    ++tmp2;
                }
                return new int[]{tmp1 + 1,tmp2 - 1};
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return notFound;
    }


}


/*
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
 */