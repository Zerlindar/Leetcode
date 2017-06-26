package leetcode;

/**
 * Created by yongfeng on 17/5/3.
 */
public class BurstBalloons_312 {

    public int maxCoins(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int newLen = len + 2;
        int[] tmp = new int[newLen];
        int[][] dp = new int[newLen][newLen];
        tmp[0] = 1;
        tmp[newLen - 1] = 1;
        for(int i = 0 ;i < len ; ++i){
            tmp[i + 1] = nums[i];
        }

        for(int i = 2 ; i < newLen ; ++i){
            for(int left = 0 ; left + i < newLen ; ++ left){
                int right = left + i;
                for(int j = left + 1; j < right ; ++j){
                    dp[left][right] = Math.max(dp[left][right] , tmp[left] * tmp[j] * tmp[right] + dp[left][j] + dp[j][right]);
                }
            }
        }

        return dp[0][newLen - 1];

    }





    public static void main(String[] args) {
        BurstBalloons_312 burstBalloons_312 = new BurstBalloons_312();
        int[] nums = {7,9,8,0,7,1,3,5,5,2,3};
        System.out.println(burstBalloons_312.maxCoins(nums));
    }

}


/*
Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons.
If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i.
After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:
(1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
(2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

Example:

Given [3, 1, 5, 8]

Return 167

    nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
   coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

 */