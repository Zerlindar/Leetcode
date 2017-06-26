package leetcode;

/**
 * Created by yongfeng on 16/12/13.
 */
public class NumArray {
    private int[] cnt;
    public NumArray(int[] nums) {
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

//    [-2,0,3,-5,2,-1],sumRange(0,2),sumRange(2,5),sumRange(0,5)

    public static void main(String[] args) {
        int[] nums = {
                -2,0,3,-5,2,-1
        };
        NumArray numArray = new NumArray(nums);

        System.out.println(numArray.sumRange(0,2));
    }
}
