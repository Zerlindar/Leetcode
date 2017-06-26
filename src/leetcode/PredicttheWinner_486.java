package leetcode;

/**
 * Created by yongfeng on 17/2/7.
 */


//Given an array of scores that are non-negative integers.
// Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on.
// Each time a player picks a number, that number will not be available for the next player.
// This continues until all the scores have been chosen. The player with the maximum score wins.
//
//        Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.
//
//        Example 1:
//        Input: [1, 5, 2]
//        Output: False
//        Explanation: Initially, player 1 can choose between 1 and 2.
//        If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player 2 chooses 5, then player 1 will be left with 1 (or 2).
//        So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
//        Hence, player 1 will never be the winner and you need to return False.
//        Example 2:
//        Input: [1, 5, 233, 7]
//        Output: True
//        Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7. No matter which number player 2 choose, player 1 can choose 233.
//        Finally, player 1 has more score (234) than player 2 (12), so you need to return True representing player1 can win.
//        Note:
//        1 <= length of the array <= 20.
//        Any scores in the given array are non-negative integers and will not exceed 10,000,000.
//        If the scores of both players are equal, then player 1 is still the winner.
//        Subscribe to see which companies asked this question.

public class PredicttheWinner_486 {

    public boolean PredictTheWinner(int[] nums) {
        int len = nums.length;

        int dp[][] = new int[len][len];

        for(int i = 0 ; i < len ; ++ i){
            dp[i][i] = nums[i];
        }

        for(int i = 1; i < len ; ++ i){
            for(int j = 0 ; j+i < len ; ++j){
                int tmp = nums[j] - dp[j+1][j+i];
                int tmp2 = nums[j+i] - dp[j][j+i-1];
                dp[j][j+ i] = tmp >= tmp2 ? tmp : tmp2;
            }
        }

        return dp[0][len-1] >= 0;
    }

    public int helper(int[]nums,int left,int right,boolean[] cnt,boolean isPlayer1){
        if(left == right){
            cnt[left] = true;
            return nums[left];
        }
        if(left > right){
            return 0;
        }

        int sum1 = nums[left];
        int sum2 = nums[right];
        int player2tmp1 = helper(nums,left+1,right,cnt,!isPlayer1);
        int player2tmp2 = helper(nums,left,right - 1,cnt,!isPlayer1);

        if(player2tmp1 >= player2tmp2){
            if(cnt[left + 1]){
                sum1 += helper(nums,left +2,right,cnt,isPlayer1);
            }
            if(cnt[right]){
                sum1 += helper(nums,left+1,right -1,cnt,isPlayer1);
            }
        }else{
            if(cnt[left]){
                sum2 += helper(nums,left+1,right-1,cnt,isPlayer1);
            }
            if(cnt[right-1]){
                sum2 += helper(nums,left,right -2 ,cnt,isPlayer1);
            }
        }

        int res = 0;
        if(sum1 >= sum2){
            cnt[left] = true;
            return sum1;
        }else{
            cnt[right] = true;
            res = sum2;
        }

        return res;
    }


    public static void main(String[] args) {
        PredicttheWinner_486 predicttheWinner_486 = new PredicttheWinner_486();
        int[] tmp = {1,5,2};

        System.out.println(predicttheWinner_486.PredictTheWinner(tmp));
    }

}
