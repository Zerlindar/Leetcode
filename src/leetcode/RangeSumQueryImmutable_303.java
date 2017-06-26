package leetcode;

/**
 * Created by yongfeng on 16/12/13.
 */




//Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//
//        Example:
//        Given nums = [-2, 0, 3, -5, 2, -1]
//
//        sumRange(0, 2) -> 1
//        sumRange(2, 5) -> -1
//        sumRange(0, 5) -> -3
//        Note:
//        You may assume that the array does not change.
//        There are many calls to sumRange function.
//        Subscribe to see which companies asked this question


public class RangeSumQueryImmutable_303 {

    private int[] cnt;

    public RangeSumQueryImmutable_303(int[] nums) {
        int len = nums.length;
        cnt = new int[len];
        int sum = 0;
        for(int i = 0 ;i < len ; ++i){
            sum += nums[i];
            cnt[i] =sum;
        }

    }

    public int sumRange(int i, int j) {
        if(i == 0){
            return cnt[j];
        }
        return cnt[j] - cnt[i-1];
    }

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);

}
