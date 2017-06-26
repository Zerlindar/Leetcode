package leetcode;

/**
 * Created by yongfeng on 17/3/1.
 */
public class KthLargestElementinanArray_215 {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        return helper(nums,0,len - 1 , k - 1);
    }


    public int helper(int[] nums,int left,int right,int target){
        int oriLeft = left;
        int oriRight = right;
        int tmp = nums[left];
        while(left < right){
            while(left < right && nums[right] <= tmp){
                --right;
            }
            nums[left] = nums[right];
            while(left < right && nums[left] >= tmp){
                ++left;
            }
            nums[right] = nums[left];
        }
        nums[left] = tmp;
        if(left == target){
            return nums[left];
        }else if (left < target){
            return helper(nums,left + 1,oriRight,target);
        }else{
            return helper(nums,oriLeft,left -1 ,target);
        }

    }


    public static void main(String[] args) {
        KthLargestElementinanArray_215 kthLargestElementinanArray_215 = new KthLargestElementinanArray_215();
        int[] nums = {3,2,1,5,6,4};
        //for(int i = 1 ;  i<= nums.length ; ++i){
            System.out.println(kthLargestElementinanArray_215.findKthLargest(nums,6));
        //}

    }


}

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.

 Credits:
 Special thanks to @mithmatt for adding this problem and creating all test cases.

 Subscribe to see which companies asked this question.
 */