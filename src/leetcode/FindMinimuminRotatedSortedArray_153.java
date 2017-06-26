package leetcode;

/**
 * Created by yongfeng on 17/3/17.
 */
public class FindMinimuminRotatedSortedArray_153 {


    public int findMin(int[] nums) {
        int len = nums.length;
        if(len == 1 ){
            return nums[0];
        }
        if(nums[0] < nums[len - 1]){
            return nums[0];
        }
        int left = 0;
        int right = len - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] >= nums[0]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return nums[left];
    }


    public int findMin2(int[] nums) {
        return helper(nums,0,nums.length - 1);
    }

    public int helper(int[]nums,int left,int right){
        if(left == right){
            return nums[left];
        }
        if(right - left == 1){
            return nums[right] < nums[left] ? nums[right] : nums[left];
        }
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid -1] > nums[mid]){
                return nums[mid];
            }else{
                int tmp1 = helper(nums,left,mid - 1);
                int tmp2 = helper(nums,mid + 1, right);
                return tmp1 < tmp2 ? tmp1 : tmp2;
            }
        }
        return nums[left];
    }


    public static void main(String[] args) {
        int[] nums = {2,1};

        FindMinimuminRotatedSortedArray_153 findMinimuminRotatedSortedArray_153 = new FindMinimuminRotatedSortedArray_153();
        System.out.println(findMinimuminRotatedSortedArray_153.findMin(nums));
    }
}
