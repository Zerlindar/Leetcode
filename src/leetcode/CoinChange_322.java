package leetcode;

import java.util.Arrays;

/**
 * Created by yongfeng on 17/1/16.
 */



//You are given coins of different denominations and a total amount of money amount.
// Write a function to compute the fewest number of coins that you need to make up that amount.
// If that amount of money cannot be made up by any combination of the coins, return -1.
//
//        Example 1:
//        coins = [1, 2, 5], amount = 11
//        return 3 (11 = 5 + 5 + 1)
//
//        Example 2:
//        coins = [2], amount = 3
//        return -1.
//
//        Note:
//        You may assume that you have an infinite number of each kind of coin.
//
//        Credits:
//        Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
//
//        Subscribe to see which companies asked this question
//
//        Show Tags

public class CoinChange_322 {


    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }

        int len = coins.length;

        if(len == 0){
            return -1;
        }

        Arrays.sort(coins);




        int[] cnt = new int[amount + 1];

        for(int i = 0 ; i <= amount ; ++i){
            cnt[i] = -1;
        }
        for(int i = 0 ; i < len ; ++i){
            if(coins[i] > amount){
                break;
            }
            cnt[coins[i]] = 1;
            if(amount == coins[i]){
                return 1;
            }
        }

        for(int i = 1 ; i <= amount ; ++i){
            for(int j = 1 ; j <= i/2; ++j){
                int tmp = i - j;
                if(cnt[j] != -1 && cnt[tmp] != -1 && (cnt[j] + cnt[tmp] < cnt[i] || cnt[i] == -1)){
                    cnt[i]= cnt[j] + cnt[tmp];
                }
            }
        }

        return cnt[amount];
    }

    public static void main(String[] args) {
        CoinChange_322 coinChange_322 = new CoinChange_322();

        int[] coins = new int[]{2};

        System.out.println(coinChange_322.coinChange(coins,3));
    }

}
