package leetcode;

import java.util.Arrays;

/**
 * Created by yongfeng on 16/11/10.
 */


//Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
//
//        Example:
//
//        Input:
//        [1,2,3]
//
//        Output:
//        3
//
//        Explanation:
//        Only three moves are needed (remember each move increments two elements):
//
//        [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]

public class MinimumMovestoEqualArrayElements_453 {
    public static  int minMoves(int[] nums) {
        int res  = 0;
        Arrays.sort(nums);
        int len = nums.length;
        int min = nums[0];
        int tmp = len -1;
        int sum = 0;
        while(tmp > 0){
            int t = Math.abs(nums[tmp] - min);
            res += t;
            min += t;
            sum += t;
            nums[--tmp] += sum;

        }
        return res;
    }

    public static void main(String[] args) {
        int[] tmp = {3,2,1};
        System.out.println(minMoves(tmp));
    }

}
