package leetcode;

/**
 * Created by sunyongfeng on 2017/7/6.
 */
public class SearchinRotatedSortedArrayII_81 {

    public boolean search(int[] nums, int target) {
        if(null == nums){
            return false;
        }
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){
                return true;
            }else if(nums[mid] == nums[left]){
                ++left;
            }else if(nums[mid] > nums[left]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid -1;
                }else{
                    left = mid + 1;
                }
            }else{
                if(target > nums[mid] && target <= nums[right]){
                    left = mid +1;
                }else{
                    right = mid -1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchinRotatedSortedArrayII_81 searchinRotatedSortedArrayII_81 = new SearchinRotatedSortedArrayII_81();
        int[] nums = {1,3,1,1,1};
        System.out.println(searchinRotatedSortedArrayII_81.search(nums,3));
    }

}


/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become  1 2 3 4 5 6 7 8 0).

Write a function to determine if a given target is in the array.

The array may contain duplicates.


 */